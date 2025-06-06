import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RuleSearchFormComponent } from '../rule-search-form/rule-search-form.component';
import { RuleCreateFormComponent } from '../rule-create-form/rule-create-form.component';

@Component({
  selector: 'app-rule-tabs',
  templateUrl: './rule-tabs.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule, RuleSearchFormComponent, RuleCreateFormComponent]
})
export class RuleTabsComponent {
  @Input() loading = false;
  @Input() scopes: any[] = [];
  @Input() selectedScope: any = null;
  @Input() searchRuleName = '';
  @Input() searchAlertText = '';
  @Input() rule = '';
  @Input() error = false;
  @Input() searchResults: any = null;
  @Input() commonEnvironment = '';

  @Output() scopeChange = new EventEmitter<any>();
  @Output() searchRules = new EventEmitter<void>();
  @Output() searchCachedRules = new EventEmitter<void>();
  @Output() submitRule = new EventEmitter<void>();
  @Output() validateRule = new EventEmitter<void>();
  @Output() searchRuleNameChange = new EventEmitter<string>();
  @Output() searchAlertTextChange = new EventEmitter<string>();
  @Output() ruleChange = new EventEmitter<string>();
  @Output() ruleDeleted = new EventEmitter<number>();
  @Output() loadingChange = new EventEmitter<boolean>();
  @Output() errorChange = new EventEmitter<boolean>();
  @Output() searchResultsChange = new EventEmitter<any>();

  activeTab = 'search';

  onScopeChange(scope: any) {
    this.scopeChange.emit(scope);
  }

  onSearchRuleNameChange(value: string) {
    this.searchRuleNameChange.emit(value);
  }

  onSearchAlertTextChange(value: string) {
    this.searchAlertTextChange.emit(value);
  }

  onRuleChange(value: string) {
    this.ruleChange.emit(value);
  }
} 