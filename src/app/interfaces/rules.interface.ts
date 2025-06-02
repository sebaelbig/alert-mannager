import { Rule } from './rule.interface';

export interface Rules {
    count: number;
    ruleList: Rule[];
    totalCount: number;
    totalPages: number;
}

export interface RuleDetails {
    ruleBody: string; //JSON string
    scopeName: string;
    alertRuleBodyId: number;
    realmRefId: number;
    alertText: string;
    ruleName: string;
    alertRuleId: number;
    customerId: number;
    payerId: number;
    providerCode: string;
    isDisabled: boolean;
  }
  