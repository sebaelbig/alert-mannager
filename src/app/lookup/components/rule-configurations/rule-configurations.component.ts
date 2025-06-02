import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-rule-configurations',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './rule-configurations.component.html'
})
export class RuleConfigurationsComponent {
  @Input() ruleConfigurations: any[] = [];

  toggleRuleBody(rule: any, index: number): void {
    const collapseElement = document.getElementById(`ruleBody${index}`);
    if (collapseElement) {
      collapseElement.classList.toggle('show');
    }
  }
}