// Enums
export enum BenefitTypeCode {
    ActiveCoverage = '1',
    ActiveFullRiskCapitation = '2',
    ActiveServicesCapitated = '3',
    ActiveServicesCapitatedToPrimaryCare = '4',
    ActivePendingInvestigation = '5',
    Inactive = '6',
    InactivePendingEligibilityUpdate = '7',
    InactivePendingInvestigation = '8',
    CoInsurance = 'A',
    CoPayment = 'B',
    Deductible = 'C',
    CoverageBasis = 'CB',
    BenefitDescription = 'D',
    // ... other values
}

export enum CoverageLevelCode {
    ChildrenOnly = 'CHD',
    DependentsOnly = 'DEP',
    EmployeeAndChildren = 'ECH',
    EmployeeOnly = 'EMP',
    EmployeeAndSpouse = 'ESP',
    Family = 'FAM',
    Individual = 'IND',
    SpouseAndChildren = 'SPC',
    SpouseOnly = 'SPO'
}

export enum YesNoIndicator {
    Unknown = 'U',
    Yes = 'Y',
    No = 'N',
    NotApplicable = 'W'
}

export enum QuantityQualifier {
    Minimum = '8H',
    QuantityUsed = '99',
    CoveredActual = 'CA',
    CoveredEstimated = 'CE',
    // ... other values
}

// Interfaces
export interface HealthcareServiceDelivery {
    quantityQlfr?: QuantityQualifier;
    quantityQlfrDesc?: string;
    quantity?: number;
    svcUnitCode?: string;
    svcUnitCodeDesc?: string;
    sampleSelectionMod?: number;
    timePeriodQlfr?: string;
    timePeriodQlfrDesc?: string;
    timePeriodCount?: number;
    deliveryFrequencyCode?: string;
    deliveryFrequencyCodeDesc?: string;
    deliveryPatternTimeCode?: string;
    deliveryPatternTimeCodeDesc?: string;
}

export interface DiagnosisCode {
    // Add diagnosis code properties once we have the class definition
    code?: string;
    description?: string;
}

export interface BenefitRelatedEntity {
    // Add related entity properties once we have the class definition
    entityId?: string;
    entityType?: string;
}

export interface BenefitError {
    // Add error properties once we have the class definition
    code?: string;
    description?: string;
}

export interface BenefitRevision {
    // Add revision properties once we have the class definition
    revisionId?: string;
    revisionDate?: string;
}

export interface Benefit {
    benefitType?: BenefitTypeCode;
    benefitTypeDesc?: string;
    coverageLevel?: CoverageLevelCode;
    coverageLevelDesc?: string;
    serviceTypes: string[];           // Max 99 items
    insurTypeCode?: string;
    insurTypeCodeDesc?: string;
    planDescription?: string;          // Between 1 and 50 characters
    timePeriodQlfr?: string;
    timePeriodQlfrDesc?: string;
    amount?: number;
    percentage?: number;
    quantityQlfr?: QuantityQualifier;
    quantityQlfrDesc?: string;
    quantity?: number;
    authRequired?: YesNoIndicator;
    authRequiredDesc?: string;
    planNetwork?: YesNoIndicator;
    planNetworkDesc?: string;
    sources?: string[];
    diagnosisCode1?: DiagnosisCode;
    diagnosisCode2?: DiagnosisCode;
    diagnosisCode3?: DiagnosisCode;
    diagnosisCode4?: DiagnosisCode;
    svcIdQlfr?: string;
    svcIdQlfrDesc?: string;
    svcIdStart?: string;              // Between 1 and 48 characters
    svcIdEnd?: string;                // Between 1 and 48 characters
    procModifier1?: string;           // Exactly 2 characters
    procModifier2?: string;           // Exactly 2 characters
    procModifier3?: string;           // Exactly 2 characters
    procModifier4?: string;           // Exactly 2 characters
    hsds: HealthcareServiceDelivery[]; // Max 9 items
    msgs: string[];                   // Max 10 items
    refs: any[];                      // Max 9 items
    dates: any[];                     // Max 20 items
    additionalInfos?: any[];           // Max 10 items
    relatedEntities?: BenefitRelatedEntity[]; // Max 23 items
    benefitErrors?: BenefitError[];    // Max 9 items
    filtered: boolean;
    benefitRevisions?: BenefitRevision[];
    instanceId?: string;
}