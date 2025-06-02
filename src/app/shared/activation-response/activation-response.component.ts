import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ActivationResponse, ApiResponse, ErrorResponse } from '../../interfaces/activation.interface';

@Component({
  selector: 'app-activation-response',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './activation-response.component.html',
  styleUrls: ['./activation-response.component.scss']
})
export class ActivationResponseComponent {
  @Input() response: ApiResponse | null = null;

  isErrorResponse(response: ApiResponse): response is ErrorResponse {
    return 'error' in response;
  }

  isActivationResponse(response: ApiResponse): response is ActivationResponse {
    return 'activations' in response;
  }
}