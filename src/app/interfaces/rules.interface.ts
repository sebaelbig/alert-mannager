export interface RulesResponse {
    count: number;
    ruleList: RuleDetails[];
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


export interface RuleRequest {
    realm: string;
    scopeId: number;
    rule: string;
}
