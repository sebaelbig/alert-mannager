import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RuleDetails } from '../../interfaces/rules.interface';
import { RealmID } from '../../interfaces/activation.interface';

@Component({
  selector: 'app-rule-response',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './rule-response.component.html',
  styleUrls: ['./rule-response.component.scss']
})
export class RuleResponseComponent {

  @Input() rules: RuleDetails[] = [];
  @Input() error: boolean = false;
  @Output() ruleDeleted = new EventEmitter<number>();

 
  isRuleArray(): boolean {
    return Array.isArray(this.rules);
  }

  isRuleObject(): boolean {
    return this.rules && typeof this.rules === 'object' && !Array.isArray(this.rules);
  }

  hasErrorMessage(): boolean {
    return this.error || (this.rules && this.error);
  }
  
  trimRuleBody(ruleBody: string): string {
    if (!ruleBody) return '';
    
    const ruleIndex = ruleBody.indexOf('rule ');
    if (ruleIndex !== -1) {
      return ruleBody.substring(ruleIndex);
    }
    return ruleBody;
  }

  getRealm(realmId: number): string {
    // Use the RealmID enum to translate the ID to its name
    switch (realmId) {
      case RealmID.PROD:
        return 'PROD';
      case RealmID.STAGE:
        return 'STAGE';
      case RealmID.DEV:
        return 'DEV';
      default:
        return `Unknown (${realmId})`;
    }
  }

  confirmDelete(rule: any): void {
    const confirmed = window.confirm(`Are you sure you want to delete the rule "${rule.ruleName}"?`);
    if (confirmed) {
      this.ruleDeleted.emit(rule.alertRuleId);
    }
  }
  
  deleteRule(ruleId: number): void {
    // Implement the actual deletion logic here, e.g., call a service
    console.log(`Deleting rule with ID: ${ruleId}`);
    // Example: this.ruleService.deleteRule(ruleId).subscribe(...)
  }
  
}
