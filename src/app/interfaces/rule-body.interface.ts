export interface RuleBody {
  /**
   * The rule text (drools logic)
   */
  body: string;

  /**
   * Alert Rule Body ID
   */
  id?: number;

  /**
   * Flag to ignore alert text validation
   */
  ignoreAlertTextValidation?: boolean;

  /**
   * Realm ID
   */
  realmId: number;
} 