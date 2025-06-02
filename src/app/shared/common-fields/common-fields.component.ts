import { Component, Output, EventEmitter, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-common-fields',
  templateUrl: './common-fields.component.html',
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class CommonFieldsComponent implements OnInit {
  @Input() commonEnvironment: string = '';
  @Input() commonAuthToken: string = '';
  @Output() commonEnvironmentChange = new EventEmitter<string>();
  @Output() commonAuthTokenChange = new EventEmitter<string>();
  tokenExpiration: string = '';

  ngOnInit() {
    // Restore values from localStorage
    const savedEnvironment = localStorage.getItem('commonEnvironment');
    const savedToken = localStorage.getItem('commonAuthToken');
    
    if (savedEnvironment) {
      this.commonEnvironment = savedEnvironment;
      this.commonEnvironmentChange.emit(savedEnvironment);
    }
    
    if (savedToken) {
      this.commonAuthToken = savedToken;
      this.commonAuthTokenChange.emit(savedToken);
      this.tokenExpiration = this.getTokenExpiration(savedToken);
    }
  }

  onEnvironmentChange(value: string) {
    this.commonEnvironment = value;
    this.commonEnvironmentChange.emit(value);
    localStorage.setItem('commonEnvironment', value);
  }

  onAuthTokenChange(value: string) {
    this.commonAuthToken = value;
    this.commonAuthTokenChange.emit(value);
    localStorage.setItem('commonAuthToken', value);
    if (value) {
      this.tokenExpiration = this.getTokenExpiration(value);
    } else {
      this.tokenExpiration = '';
    }
  }

  isTokenExpired(token: string): boolean {
    if (!token) return false;
    try {
      const base64Url = token.split('.')[1];
      const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
      const jsonPayload = decodeURIComponent(atob(base64).split('').map(c => {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
      }).join(''));
      const { exp } = JSON.parse(jsonPayload);
      if (Date.now() >= exp * 1000) {
        this.tokenExpiration = this.getTokenExpiration(token);
        return true;
      }
      return false;
    } catch (e) {
      return false;
    }
  }

  getTokenExpiration(token: string): string {
    try {
      const base64Url = token.split(".")[1];
      const base64 = base64Url.replace(/-/g, "+").replace(/_/g, "/");
      const jsonPayload = decodeURIComponent(
        atob(base64)
          .split("")
          .map(function (c) {
            return "%" + ("00" + c.charCodeAt(0).toString(16)).slice(-2);
          })
          .join("")
      );

      const payload = JSON.parse(jsonPayload);
      if (payload.exp) {
        return new Date(payload.exp * 1000).toLocaleString();
      }
      return "No expiration found in token";
    } catch (e) {
      return "Invalid token format";
    }
  }
}