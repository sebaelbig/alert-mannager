export interface CachedRule {
  alertText: string;
  dbAlertText: string;
  ruleId: number;
  ruleIdsContained: number[] | null;
  ruleName: string;
  scopeId: number;
  ruleBody: string | null;
} 

export interface CachedRulesResponse {
  count: number;
  ruleList: CachedRule[];
  totalCount: number;
  totalPages: number;
}