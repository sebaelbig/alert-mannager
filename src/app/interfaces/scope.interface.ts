export interface Scope {
  /**
   * Scope Description
   */
  description?: string;

  /**
   * The scope is disabled by default
   */
  disabledByDefault?: boolean;

  /**
   * Scope ID
   */
  id?: number;

  /**
   * Scope Name
   */
  name: string;

  /**
   * The product associated with the scope
   */
  productId: number;

  /**
   * Rules in the scope will stop running after a single hit
   */
  terminateAfterHit?: boolean;

  /**
   * The last user to update the scope
   */
  username?: string;

  /**
   * The scope will be invalidated on this date
   */
  validUntil?: string;
} 