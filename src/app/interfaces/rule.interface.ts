import { RuleBody } from "./rule-body.interface";
import { Message } from "./message.interface";
import { Scope } from "./scope.interface";


export interface Rule {
  /**
   * The day and time this rule was created
   */
  createTimestamp?: string;

  /**
   * The user who created this rule
   */
  createUsername?: string;

  /**
   * This rule is disabled by default
   */
  disabledByDefault?: boolean;

  /**
   * Alert Rule ID
   */
  id?: number;

  /**
   * The day and time this rule was last updated
   */
  lastUpdateTimestamp?: string;

  /**
   * The message associated with this rule
   */
  message: Message;

  /**
   * Alert Rule Name
   */
  name: string;

  /**
   * Rule Body Request associated with this rule
   */
  ruleBody?: RuleBody;

  /**
   * The scope this rule belongs to
   */
  scope: Scope;

  /**
   * The last user to update this rule
   */
  username?: string;
} 