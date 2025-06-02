import { Benefit } from './benefit.interface';
import { DatePeriodQlfr } from './date-period-qlfr.enum';

// Base interface for common entity properties
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

interface Contact {
  contactFunctionCode?: string;
  contactFunctionCodeDesc?: string;
  name?: string;
  contactNumQlfr1?: string;
  contactNumQlfrDesc1?: string;
  contactNum1?: string;
  contactNumQlfr2?: string;
  contactNumQlfrDesc2?: string;
  contactNum2?: string;
  contactNumQlfr3?: string;
  contactNumQlfrDesc3?: string;
  contactNum3?: string;
}

export interface Ref {
  refIdQlfr?: string;
  refIdQlfrDesc?: string;
  refId?: string;
  description?: string;
}

export interface TransactionHeader {
  senderId?: string;
  recvId?: string;
  interchangeTimeStamp?: Date;
  interchangeCtrlNum?: string;
  groupCtrlNum?: string;
  transSetCtrlNum?: string;
  transRefId?: string;
}

export interface Payer extends EntityBase {
  contacts?: Contact[];
  refs?: Ref[];
}

export interface Provider extends EntityBase {
  refs?: Ref[];
  provCode?: string;
  provCodeDesc?: string;
  refIdQlfr?: string;
  refIdQlfrDesc?: string;
  taxonomyId?: string;
}

export interface Insured extends EntityBase {
  genderCode?: string;
  genderCodeDesc?: string;
  dateOfBirth?: Date;
  addressLine1?: string;
  addressLine2?: string;
  city?: string;
  state?: string;
  zipcode?: string;
  countryCode?: string;
  countrySubdivisionCode?: string;
  indRelCode?: string;
  indRelCodeDesc?: string;
  refs?: Ref[];
  dates?: EligibilityDate[];
}

export interface ResponseError {
  errorScope?: string;
  errorScopeDesc?: string;
  validRequestIndicator?: string;
  validRequestIndicatorDesc?: string;
  rejectReasonCode?: string;
  rejectReasonCodeDesc?: string;
  followUpActionCode?: string;
  followUpActionCodeDesc?: string;
}

export interface EligibilityResponse {
  header?: TransactionHeader;
  payer?: Payer;
  provider?: Provider;
  subscriber?: Insured;
  dependent?: Insured;
  errors?: ResponseError[];
  benefits: Benefit[];
  refSegments?: Ref[];
  substantiations?: any[]; // Type can be defined if needed
  traceNumbers?: any[]; // Type can be defined if needed
}

export interface EligibilityDate {
    datePeriodQlfr?: DatePeriodQlfr;
    datePeriodQlfrDesc?: string;
    startDate?: string;  // ISO date string
    endDate?: string;    // ISO date string
}