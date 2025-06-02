import { Routes } from '@angular/router';
import { LookupComponent } from './lookup/lookup.component';
import { RulesComponent } from './rules/rules.component';
import { ScopesComponent } from './scopes/scopes.component';

export const routes: Routes = [
  { path: '', redirectTo: '/lookup', pathMatch: 'full' },
  { path: 'lookup', component: LookupComponent },
  { path: 'rules', component: RulesComponent },
  { path: 'scopes', component: ScopesComponent }
];
