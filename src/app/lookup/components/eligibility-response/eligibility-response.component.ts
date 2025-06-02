import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-eligibility-response',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './eligibility-response.component.html'
})
export class EligibilityResponseComponent {
  @Input() eligibilityResponse: any;
  showBenefits = false;
}