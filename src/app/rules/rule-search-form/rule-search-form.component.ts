import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { RulesResponse } from '../../interfaces/rules.interface';
import { CachedRulesResponse } from '../../interfaces/cached-rule.interface';

@Component({
  selector: 'app-rule-search-form',
  templateUrl: './rule-search-form.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule],
  styleUrls: ['./rule-search-form.component.scss']
})
export class RuleSearchFormComponent {
  @Input() loading = false;
  @Input() scopes: any[] = [];
  @Input() selectedScope: any = null;
  @Input() searchRuleName = '';
  @Input() searchAlertText = '';
  @Input() error = false;
  @Input() commonEnvironment = '';
  @Input() searchResults: CachedRulesResponse | null = null;

  @Output() scopeChange = new EventEmitter<any>();
  @Output() searchRules = new EventEmitter<void>();
  @Output() searchCachedRules = new EventEmitter<void>();
  @Output() searchRuleNameChange = new EventEmitter<string>();
  @Output() searchAlertTextChange = new EventEmitter<string>();
  @Output() loadingChange = new EventEmitter<boolean>();
  @Output() errorChange = new EventEmitter<boolean>();
  @Output() searchResultsChange = new EventEmitter<RulesResponse | null>();

  constructor(private http: HttpClient) {}

  onScopeChange(scope: any) {
    this.scopeChange.emit(scope);
  }

  onSearchRuleNameChange(value: string) {
    this.searchRuleNameChange.emit(value);
  }

  onSearchAlertTextChange(value: string) {
    this.searchAlertTextChange.emit(value);
  }

  searchCachedRulesLocal(): void {
    this.loadingChange.emit(true);
    this.errorChange.emit(false);

    const params: any = {
      realmId: this.commonEnvironment,
    };

    if (this.selectedScope?.name?.trim()) {
      params.scope = this.selectedScope.name;
    }
    if (this.searchRuleName?.trim()) {
      params.ruleName = this.searchRuleName;
    }
    if (this.searchAlertText?.trim()) {
      params.alertText = this.searchAlertText;
    }

    this.http.get<any>(`/api/rules/cached`, { params }).subscribe({
      next: (response) => {
        this.searchResultsChange.emit(response);
        this.loadingChange.emit(false);
      },
      error: (error) => {
        console.error('Error fetching revenue cycle rules:', error);
        this.errorChange.emit(true);
        this.loadingChange.emit(false);
      },
    });
  }

  trimRuleBody(ruleBody: string): string {
    if (!ruleBody) return '';
    
    const ruleIndex = ruleBody.indexOf('rule ');
    if (ruleIndex !== -1) {
      return ruleBody.substring(ruleIndex);
    }
    return ruleBody;
  }
} 