import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RuleResponseComponent } from '../../shared/rule-response/rule-response.component';
import { RulesResponse } from '../../interfaces/rules.interface';

@Component({
  selector: 'app-rule-create-form',
  templateUrl: './rule-create-form.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule, RuleResponseComponent]
})
export class RuleCreateFormComponent {
  @Input() loading = false;
  @Input() scopes: any[] = [];
  @Input() selectedScope: any = null;
  @Input() rule = '';
  @Input() error = false;
  @Input() searchResults: RulesResponse | null = null;

  @Output() scopeChange = new EventEmitter<any>();
  @Output() ruleChange = new EventEmitter<string>();
  @Output() submitRule = new EventEmitter<void>();
  @Output() validateRule = new EventEmitter<void>();
  @Output() ruleDeleted = new EventEmitter<number>();

  onScopeChange(scope: any) {
    this.scopeChange.emit(scope);
  }

  onRuleChange(value: string) {
    this.ruleChange.emit(value);
  }

} 