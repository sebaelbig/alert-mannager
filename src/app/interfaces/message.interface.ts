export interface Message {
  /**
   * Message Description
   */
  description?: string;

  /**
   * Alert Text Reference ID
   */
  id?: number;

  /**
   * Alert Text
   */
  text: string;

  /**
   * The last user to update this message
   */
  timestamp?: string;

  /**
   * The last user to update this message
   */
  username?: string;

  /**
   * Message will be valid until this date
   */
  validUntil?: string;
} 