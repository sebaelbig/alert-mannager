import { Component, ViewChild, ElementRef } from '@angular/core';
import { HttpClient, HttpParams, HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CommonFieldsComponent } from '../shared/common-fields/common-fields.component';
import { catchError, switchMap, throwError } from 'rxjs';
import { Toast } from 'bootstrap';
import { AlertConfiguration } from '../interfaces/alert-configuration.interface';
import { DatamartDTO } from '../interfaces/datamart.interface';
import { RuleConfigurationsComponent } from './components/rule-configurations/rule-configurations.component';
import { SqlResultsComponent } from './components/sql-results/sql-results.component';
import { EligibilityResponseComponent } from './components/eligibility-response/eligibility-response.component';
import { RequestDetailsComponent } from "./components/request-details/request-details.component";

@Component({
  selector: 'app-lookup',
  templateUrl: './lookup.component.html',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CommonFieldsComponent,
    HttpClientModule,
    RuleConfigurationsComponent,
    SqlResultsComponent,
    EligibilityResponseComponent,
    RequestDetailsComponent
],
})
export class LookupComponent {
  bht03Code: string = '';
  private _prsUuid: string | null = null;
  sqlResults: DatamartDTO | null = null;
  ruleConfigurations: AlertConfiguration[] = [];
  loading: boolean = false;
  error: string | null = null;
  showBenefits: boolean = false;
  commonEnvironment: string = 'DEV';
  commonAuthToken: string = '';

  constructor(private http: HttpClient) {}

  onCommonFieldsChange(field: 'environment' | 'token', value: string) {
    if (field === 'environment') {
      this.commonEnvironment = value;
      // Reset form state when environment changes
      this.prsUuid = null;
      this.sqlResults = null;
      this.ruleConfigurations = [];
      this.error = null;
    } else if (field === 'token') {
      this.commonAuthToken = value;
      // Validate new token
      if (this.isTokenExpired(value)) {
        this.error = 'The provided auth token is expired';
      } else {
        this.error = null;
      }
    }
  }

  get prsUuid(): string | null {
    return this._prsUuid;
  }

  set prsUuid(value: string | null) {
    this._prsUuid = value?.trim() || null;
  }

  getLookupDetails() {
    if (!this.prsUuid) {
      throw new Error('PRS UUID is not available');
    }
    return this.http.get<any>('/api/lookup/details', {
      params: new HttpParams()
        .set('realmid', this.commonEnvironment)
        .set('prsUuid', this.prsUuid),
    });
  }

  refreshDetails(): void {
    if (!this.prsUuid) {
      this.error = 'No PRS UUID available to refresh details';
      return;
    }

    this.loading = true;
    this.error = null;

    this.getLookupDetails().subscribe({
      next: (detailsResponse) => {
        if (detailsResponse) {
          this.sqlResults = detailsResponse.sqlResults || [];
          this.ruleConfigurations = detailsResponse.ruleConfigurations || [];
        } else {
          this.error = 'No results found or invalid response';
        }
      },
      error: ({ error, message }) => {
        this.error = error.message;
        console.error('Refresh error:', message);
      },
      complete: () => {
        this.loading = false;
      },
    });
  }

  performLookup(): void {
    if (!this.bht03Code) {
      this.error = 'Please enter a BHT03 code';
      return;
    }

    this.loading = true;
    this.error = null;
    this.prsUuid = null;
    this.sqlResults = null;
    this.ruleConfigurations = [];

    const params = new HttpParams()
      .set('bht03Code', this.bht03Code)
      .set('realmid', this.commonEnvironment);

    this.http
      .get<any>('/api/lookup/uuid', { params })
      .pipe(
        switchMap((response) => {
          if (response?.uuid) {
            this.prsUuid = response.uuid;
            return this.getLookupDetails();
          }
          throw new Error('No UUID found in response');
        }),
        catchError((error) => {
          const message =
            error.error?.message || error.statusText || 'Unknown error';
          this.loading = false;
          return throwError(
            () => new Error(`Error performing lookup: ${message}`)
          );
        })
      )
      .subscribe({
        next: (detailsResponse) => {
          if (detailsResponse) {
            this.sqlResults = detailsResponse.sqlResults || [];
            this.ruleConfigurations = detailsResponse.ruleConfigurations || [];
          } else {
            this.error = 'No results found or invalid response';
          }
        },
        error: (error) => {
          this.error = error.message;
          console.error('Lookup error:', error);
        },
        complete: () => {
          this.loading = false;
        },
      });
  }

  formatJson(jsonString: string): string {
    try {
      const obj = JSON.parse(jsonString);
      if (obj.ruleBody) {
        const ruleIndex = obj.ruleBody.indexOf('rule');
        if (ruleIndex !== -1) {
          obj.ruleBody = obj.ruleBody.substring(ruleIndex);
        }
      }
      return JSON.stringify(obj, null, 2);
    } catch (e) {
      return jsonString;
    }
  }

  @ViewChild('toast') toastEl!: ElementRef;
  async copyToClipboard(text: string): Promise<void> {
    try {
      await navigator.clipboard.writeText(text);
      const toast = new Toast(this.toastEl.nativeElement);
      toast.show();
    } catch (err) {
      console.error('Failed to copy text: ', err);
    }
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
}
