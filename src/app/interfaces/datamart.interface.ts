import { EligibilityResponse } from "./eligibility.interface";

// Add ProviderInterface import once it's created
// import { ProviderInterface } from './provider-interface';

export interface AlertRequest {
    host?: string;                    // Max 64 characters
    realmId?: number;                 // PROD=1|2, STAGE=3, TEST=4
    customerId?: number;              // OIT Customer ID
    encounterRid: UUID;               // Required
    providerCode: string;             // Required, max 35 characters
    regionCode: string;               // Required, max 35 characters
    recoPayerId: string;              // Required, max 35 characters
    isSpv: boolean;                   // Required, Indicator for Self Pay
    isMedicare: boolean;              // Required, Indicator for Medicare
    isMedicaid: boolean;              // Required, Indicator for Medicaid
    isOutOfNetwork?: boolean;         // Indicator for Out of Network Payers
    memberNumber?: string;            // Max 50 characters
    enteredMemberNumber?: string;     // Max 50 characters
    groupNumber?: string;             // Max 50 characters
    genderCode?: string;              // Max 50 characters
    subscriberRelationship?: string;  // Max 50 characters
    patientType?: string;             // Max 65 characters
    medicalService?: string;          // Max 100 characters
    patientState?: string;            // Exactly 2 characters
    patientZip?: string;              // Between 3 and 15 characters
    dateOfService: string;            // Required, ISO date string
    dateOfBirth?: string;             // ISO date string
    providerInterface?: ProviderInterface;  // Optional ProviderInterface
    eligibilityResponse: EligibilityResponse; // Required
    revenueCodes?: string[];          // Optional array of revenue codes
    procedureCodes?: string[];        // Optional array of procedure codes
}

export interface DatamartDTO {
  requestBodyJSON: string;
  requestBody: AlertRequest;
  responseBody: AlertResponse;
}

export interface AlertResponse {
  generatedAlerts: GeneratedAlert[];
  transactionId: UUID;
  host: string;
  encounterRid: UUID;
  hideAccount: boolean;
}

export interface GeneratedAlert {
  product: string;
  text: string;
  key: string;
  value: string;
  benefitId: string;
}

// Type for UUID if not already defined
export type UUID = string;

export interface PayerPlan {
    hisPayerId?: string;    // Max 100 characters
    hisPayer?: string;      // Max 100 characters
    hisPlan?: string;       // Max 100 characters
}

export interface ProviderInterface {
    payerPlan: PayerPlan;   // Required
}
