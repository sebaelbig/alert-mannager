import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-request-details',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './request-details.component.html',
  styleUrls: ['./request-details.component.scss']
})
export class RequestDetailsComponent {
  @Input() sqlResults: any; // TODO: Add proper type

  copyToClipboard(text: string): void {
    navigator.clipboard.writeText(text);
  }
}