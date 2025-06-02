import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-sql-results',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './sql-results.component.html'
})
export class SqlResultsComponent {
  @Input() sqlResults: any;

  formatJson(json: any): string {
    return JSON.stringify(json, null, 2);
  }

  copyRequestBody(): void {
    if (this.sqlResults?.requestBodyJSON) {
      const textToCopy = JSON.stringify(this.sqlResults.requestBodyJSON, null, 2);
      navigator.clipboard.writeText(textToCopy)
        .then(() => {
          // Optionally add a success notification
          console.log('Content copied to clipboard');
        })
        .catch(err => {
          console.error('Failed to copy content: ', err);
        });
    }
  }
}