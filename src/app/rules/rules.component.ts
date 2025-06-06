import { Component, OnInit } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpClientModule,
} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CommonFieldsComponent } from '../shared/common-fields/common-fields.component';
import { Scope } from '../interfaces/scope.interface';
import { RulesResponse, RuleDetails, RuleRequest } from '../interfaces/rules.interface';
import { RuleResponseComponent } from '../shared/rule-response/rule-response.component';
import { Observable } from 'rxjs';
import { finalize, tap } from 'rxjs/operators';
import { RuleTabsComponent } from './rule-tabs/rule-tabs.component';

interface Rule {
  name: string;
  ruleBody: string;
  salience: number;
}

interface BulkRuleResponse {
  results: Array<{
    ruleName: string;
    status?: string;
    error?: string;
    response?: string;
  }>;
  totalRules: number;
  successCount: number;
  hasErrors: boolean;
}

@Component({
  selector: 'app-rules',
  templateUrl: './rules.component.html',
  styleUrls: ['./rules.component.scss'],
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CommonFieldsComponent,
    HttpClientModule,
    RuleTabsComponent,
  ],
})
export class RulesComponent implements OnInit {
  commonEnvironment: string = 'DEV';
  commonAuthToken: string = '';
  rule: string = '';
  loading: boolean = false;
  response: any = null;
  error: boolean = false;
  scopes: Scope[] = [];
  selectedScope: Scope | null = null;
  searchRuleName: string = '';
  searchAlertText: string = '';
  searchResults: RulesResponse | null = null;
  activeTab: string = 'search';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadScopes().then(() => {
      // After scopes are loaded, try to restore the selected scope
      const savedScopeId = localStorage.getItem('selectedScopeId');
      if (savedScopeId) {
        const scope = this.scopes.find(
          (s) => s.id === parseInt(savedScopeId, 10)
        );
        if (scope) {
          this.selectedScope = scope;
        }
      }
    });
  }

  loadScopes(): Promise<void> {
    return new Promise((resolve) => {
      this.http
        .get<{ scopes: Scope[] }>(
          `/api/scopes?realmId=${this.commonEnvironment}`
        )
        .subscribe({
          next: (response) => {
            this.scopes = (response.scopes || []).sort((a, b) =>
              (a.name || '').localeCompare(b.name || '')
            );
            resolve();
          },
          error: (error) => {
            console.error('Error loading scopes:', error);
            resolve();
          },
        });
    });
  }

  submitRule(): void {
    if (
      !this.rule ||
      !this.commonEnvironment ||
      !this.selectedScope ||
      !this.selectedScope.id
    ) {
      return;
    }

    this.loading = true;
    this.response = null;
    this.error = false;

    const requestData: RuleRequest = {
      realm: this.commonEnvironment,
      scopeId: this.selectedScope.id,
      rule: this.rule,
    };

    this.http.post<any>('/api/rules/create', requestData).subscribe({
      next: (response) => {
        this.response = response;
        this.loading = false;
      },
      error: (error) => {
        this.error = true;
        this.loading = false;
        console.error('Error creating rule:', error);
      },
    });
  }

  searchRules(): void {
    if (!this.commonEnvironment) {
      this.error = true;
      this.response = { error: 'Environment is required' };
      return;
    }

    this.loading = true;
    this.response = null;
    this.error = false;

    const params: any = {
      realmId: this.commonEnvironment,
    };

    // Only add optional parameters if they have values
    if (this.selectedScope?.name?.trim()) {
      params.scope = this.selectedScope.name;
    }
    if (this.searchRuleName?.trim()) {
      params.ruleName = this.searchRuleName;
    }
    if (this.searchAlertText?.trim()) {
      params.alertText = this.searchAlertText;
    }

    this.http
      .get<{ rules: RuleDetails[] }>('/api/rules', { params })
      .subscribe({
        next: (response) => {
          this.searchResults = response.rules as unknown as RulesResponse;
          this.response = response;
          this.loading = false;
        },
        error: (error) => {
          this.error = true;
          this.loading = false;
          this.response = { error: 'Failed to search rules' };
          console.error('Error searching rules:', error);
        },
      });
  }

  isTokenExpired(token: string): boolean {
    if (!token) return false;
    try {
      const base64Url = token.split('.')[1];
      const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      const jsonPayload = decodeURIComponent(
        atob(base64)
          .split('')
          .map((c) => {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
          })
          .join('')
      );
      const { exp } = JSON.parse(jsonPayload);
      return Date.now() >= exp * 1000;
    } catch (e) {
      return false;
    }
  }

  onCommonFieldsChange(field: 'environment' | 'token', value: string) {
    if (field === 'environment') {
      this.commonEnvironment = value;
      // Reset form state when environment changes
      this.response = null;
      this.error = false;
      // Clear selected scope since we're changing environments
      this.selectedScope = null;
      // Reload scopes for new environment
      this.loadScopes();
    } else if (field === 'token') {
      this.commonAuthToken = value;
      // Validate new token
      if (this.isTokenExpired(value)) {
        this.error = true;
        this.response = { error: 'The provided auth token is expired' };
      } else {
        this.error = false;
        this.response = null;
      }
    }
  }

  // deleteRule(ruleId: number): void {
  //   if (!this.commonEnvironment || !this.commonAuthToken) {
  //     return;
  //   }

  //   this.loading = true;
  //   this.response = null;
  //   this.error = false;

  //   const headers = {
  //     Authorization: this.commonAuthToken,
  //   };

  //   this.http
  //     .delete<any>(`/api/rules/${this.commonEnvironment}/${ruleId}`, {
  //       headers,
  //     })
  //     .subscribe({
  //       next: (response) => {
  //         this.searchResults.rules = this.searchResults.rules.filter(
  //           (rule) => rule.alertRuleId !== ruleId
  //         );
  //         this.response = response;
  //         this.loading = false;
  //       },
  //       error: (error) => {
  //         this.error = true;
  //         this.loading = false;
  //         console.error('Error creating rule:', error);
  //       },
  //     });
  //   // Optionally, call a backend service to delete the rule
  //   // this.ruleService.deleteRule(ruleId).subscribe(() => {
  //   //   console.log(`Rule ${ruleId} deleted successfully.`);
  //   // });
  // }

  submitBulkRules(rules: RuleRequest[]): Observable<BulkRuleResponse> {
    if (!this.commonEnvironment || !this.commonAuthToken) {
      throw new Error('Environment and auth token are required');
    }

    this.loading = true;
    this.response = null;
    this.error = false;

    const headers = {
      Authorization: this.commonAuthToken,
    };

    return this.http
      .post<BulkRuleResponse>('/api/rules/bulk', rules, { headers })
      .pipe(
        finalize(() => {
          this.loading = false;
        }),
        tap(
          (response) => {
            this.response = response;
            if (response.hasErrors) {
              this.error = true;
              console.warn(
                'Some rules failed to create:',
                response.results.filter((r) => r.error)
              );
            }
          },
          (error) => {
            this.error = true;
            this.response = { error: 'Failed to create rules' };
            console.error('Error creating rules:', error);
          }
        )
      );
  }

  createMultipleRules(
    ruleConfigs: Array<{ name: string; body: string; scope: string }>
  ) {
    if (!this.commonEnvironment || !this.selectedScope?.id) {
      this.error = true;
      this.response = { error: 'Environment and valid scope are required' };
      return;
    }

    const rules = ruleConfigs.map((config) => ({
      realm: this.commonEnvironment,
      scopeId: this.selectedScope!.id!,
      rule: config.body,
    }));

    this.submitBulkRules(rules).subscribe({
      next: (response) => {
        if (response.hasErrors) {
          // Handle partial success
          const successCount = response.successCount;
          const failedRules = response.results.filter((r) => r.error);
          console.log(
            `Created ${successCount} rules successfully. ${failedRules.length} rules failed.`
          );
        } else {
          console.log('All rules created successfully');
        }
      },
      error: (error) => {
        console.error('Failed to create rules:', error);
      },
    });
  }

  private getRealmId(environment: string): number {
    switch (environment.toUpperCase()) {
      case 'PROD':
        return 1;
      case 'STAGE':
        return 3;
      case 'TEST':
        return 4;
      case 'DEV':
      default:
        return 4;
    }
  }

  getEnvironmentColor(): string {
    switch (this.commonEnvironment) {
      case 'DEV':
        return '#cdebf5';
      case 'STAGE':
        return '#f5eccd';
      case 'PROD':
        return '#f5d8cd';
      default:
        return '#ffffff';
    }
  }

  onScopeChange(scope: Scope) {
    this.selectedScope = scope;
    if (scope && scope.id) {
      localStorage.setItem('selectedScopeId', scope.id.toString());
    } else {
      localStorage.removeItem('selectedScopeId');
    }
  }

  validateRule(): void {
    if (
      !this.rule ||
      !this.commonEnvironment ||
      !this.selectedScope ||
      !this.selectedScope.id
    ) {
      return;
    }

    this.loading = true;
    this.response = null;
    this.error = false;

    const requestData: RuleRequest = {
      realm: this.commonEnvironment,
      scopeId: this.selectedScope.id,
      rule: this.rule,
    };

    this.http.post<any>('/api/rules/validate', requestData).subscribe({
      next: (response) => {
        this.response = response;
        this.loading = false;
      },
      error: (error) => {
        this.error = true;
        this.loading = false;
        console.error('Error validating rule:', error);
        this.response = { error: error.error || 'Failed to validate rule' };
      },
    });
  }

}
