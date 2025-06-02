import { Component, OnInit } from '@angular/core';
import {
  HttpClient,
  HttpParams,
  HttpErrorResponse,
  HttpClientModule,
} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CommonFieldsComponent } from '../shared/common-fields/common-fields.component';
import { ActivationResponseComponent } from '../shared/activation-response/activation-response.component';
import { Scope } from '../interfaces/scope.interface';
import { ActivationResponse, ApiResponse } from '../interfaces/activation.interface';

@Component({
  selector: 'app-scopes',
  templateUrl: './scopes.component.html',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule,
    CommonFieldsComponent,
    HttpClientModule,
    ActivationResponseComponent
  ],
})
export class ScopesComponent implements OnInit {
  commonEnvironment: string = 'DEV';
  commonAuthToken: string = '';
  scopeName: string = '';
  customerId: string = '';
  loading: boolean = false;
  response: ApiResponse | null = null;
  error: boolean = false;

  scopes: Scope[] = [];
  selectedScope: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit(): void {
    this.loadScopes();
  }

  loadScopes(): void {
    this.http.get<{scopes: Scope[]}>(`/api/scopes?realmId=${this.commonEnvironment}`)
      .subscribe({
        next: (response) => {
          this.scopes = (response.scopes || []).sort((a, b) => 
            (a.name || '').localeCompare(b.name || '')
          );
        },
        error: (error) => {
          console.error('Error loading scopes:', error);
        }
      });
  }
  create(): void {
    if (!this.scopeName || !this.commonEnvironment) {
      return;
    }

    this.loading = true;
    this.response = null;
    this.error = false;

    const requestData = {
      realm: this.commonEnvironment,
      authToken: this.commonAuthToken,
      scope: {
        disabledByDefault: false,
        name: this.scopeName.toUpperCase(),
        productId: 3,
        terminateAfterHit: true,
      },
    };

    this.http.post<any>('/api/scopes', requestData).subscribe({
      next: (response) => {
        this.response = response;
        this.loading = false;
      },
      error: (error) => {
        this.error = true;
        this.loading = false;
        console.error('Error creating scope:', error);
      },
    });
  }

  deleteScope(): void {
    if (!this.scopeName || !this.commonEnvironment) {
      return;
    }

    this.loading = true;
    this.response = null;
    this.error = false;

    const headers = {
      Authorization: this.commonAuthToken,
      Realm: this.commonEnvironment,
    };

    this.http
      .delete<any>(
        `/api/scopes/${this.scopeName.toUpperCase()}`,
        { headers }
      )
      .subscribe({
        next: (response) => {
          this.response = response;
          this.loading = false;
        },
        error: (error: HttpErrorResponse) => {
          this.error = true;
          this.loading = false;
          console.error('Error deleting scope:', error);
        },
      });
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

  onCommonFieldsChange(field: 'environment' | 'token', value: string) {
    if (field === 'environment') {
      this.commonEnvironment = value;
      // Reset form state when environment changes
      this.scopeName = '';
      this.response = null;
      this.error = false;
    } else if (field === 'token') {
      this.commonAuthToken = value;
      if (this.isTokenExpired(value)) {
        this.error = true;
        this.response = { error: 'The provided auth token is expired' };
      } else {
        this.error = false;
        this.response = null;
      }
    }
  }

  getActivation() {
    if ((!this.scopeName && !this.selectedScope) || !this.commonEnvironment) {
      return;
    }

    this.loading = true;
    this.response = null;
    this.error = false;
    
    const params: any = {
      realmid: this.commonEnvironment
    };

    // Only add optional parameters if they have values
    if (this.selectedScope?.trim()) {
      params.scopeName = this.selectedScope;
    } else if (this.scopeName?.trim()) {
      params.scopeName = this.scopeName;
    }
   
    this.http.get<any>('/api/scopes/activation', { params })
      .subscribe({
        next: (response) => {
          this.response = response;
          this.loading = false;
        },
        error: (error) => {
          this.error = true;
          this.loading = false;
          console.error('Error creating rule:', error);
        }
      });
  }
}
