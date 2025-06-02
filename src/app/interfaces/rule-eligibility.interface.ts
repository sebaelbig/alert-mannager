// Common interfaces used across multiple components
interface EntityBase {
  entityIdCode?: string;
  entityIdCodeDesc?: string;
  entityTypeQlfr?: string;
  entityTypeQlfrDesc?: string;
  firstName?: string;
  lastName?: string;
  middleName?: string;
  nameSuffix?: string;
  idCodeQlfr?: string;
  idCodeQlfrDesc?: string;
  idCode?: string;
}

interface RuleRef {
  refIdQlfr: string; //REF01
  refIdQlfrDesc: string;
  refId: string; //REF02
  description: string; //REF03
}

interface RuleContact {
  contactFunctionCode: string;
  contactFunctionCodeDesc: string;
  name: string;
  contactNumQlfr1: string;
  contactNumQlfrDesc1: string;
  contactNum1: string;
  contactNumQlfr2: string;
  contactNumQlfrDesc2: string;
  contactNum2: string;
  contactNumQlfr3: string;
  contactNumQlfrDesc3: string;
  contactNum3: string;
}

interface RuleEligibilityDate {
  datePeriodQlfr: string;
  datePeriodQlfrDesc: string;
  start: Date;
  endDate: Date;
}

// Main interfaces
export interface RuleTransactionHeader {
  authInfoQlfr?: string;
  authInfoQlfrDesc?: string;
  authInfo?: string;
  senderId?: string;
  recvId?: string;
  interchangeTimeStamp?: Date;
  interchangeCtrlNum?: string;
  groupCtrlNum?: string;
  transSetCtrlNum?: string;
  transRefId?: string;
}

export interface RulePayer extends EntityBase {
  contacts?: RuleContact[];
  refs?: RuleRef[];
}

export interface RuleProvider extends EntityBase {
  refs?: RuleRef[];
  provCode?: string;
  provCodeDesc?: string;
  refIdQlfr?: string;
  refIdQlfrDesc?: string;
  taxonomyId?: string;
}

export interface RuleInsured extends EntityBase {
  genderCode?: string;
  genderCodeDesc?: string;
  dateOfBirth?: Date;
  addressLine1?: string;
  addressLine2?: string;
  city?: string;
  state?: string;
  zipcode?: string;
  countryCode?: string;
  indRelCode?: string;
  indRelCodeDesc?: string;
  refs?: RuleRef[];
  dates?: RuleEligibilityDate[];
}

export interface RuleBenefit {
  benefitType?: string;
  benefitTypeDesc?: string;
  coverageLevel?: string;
  coverageLevelDesc?: string;
  serviceTypes?: string[];
  planDescription?: string;
  amount?: number;
  percentage?: number;
  planNetwork?: string;
  planNetworkDesc?: string;
  msgs?: string[];
  refs?: RuleRef[];
  dates?: RuleEligibilityDate[];
}

export interface RuleResponseError {
  errorScope?: string;
  errorScopeDesc?: string;
  validRequestIndicator?: string;
  validRequestIndicatorDesc?: string;
  rejectReasonCode?: string;
  rejectReasonCodeDesc?: string;
  followUpActionCode?: string;
  followUpActionCodeDesc?: string;
}

// Main response interface
export interface RuleEligibilityResponse {
  header?: RuleTransactionHeader;
  payer?: RulePayer;
  provider?: RuleProvider;
  subscriber?: RuleInsured;
  dependent?: RuleInsured;
  errors?: RuleResponseError[];
  benefits?: RuleBenefit[];
  refSegments?: RuleRef[];
}
