export interface ActivationResponse {
    activations: Activation[];
    count: number;
    totalCount: number;
    totalPages: number;
}

export interface Activation {
    activationEntities: ActivationEntity[];
    activeRealms: RealmID[];
    count: number;
    id: number;
    name: string;
}

export interface ActivationEntity {
    customer?: Customer;
    id?: number;
    isDisabled: boolean;
    lastUpdateTimestamp: string;
    lastUpdateUsername: string;
    payer?: Payer;
    providerCode: string;
    realm?: RealmID;
}

export interface Customer {
    id: number;
    name: string;
}

export interface Payer {
    name: string;
    prsRecoPayerId?: number;
    recId: string;
}

export enum RealmID {
    DEV = 4,
    STAGE = 3,
    PROD = 1
}

// Additional RealmID metadata interface if needed
export interface RealmMetadata {
    value: number;
    name: string;
    scopeApiUrl: string;
}

// Mapping of RealmID to metadata if needed
export const REALM_METADATA: Record<RealmID, RealmMetadata> = {
    [RealmID.DEV]: {
        value: 4,
        name: 'TEST',
        scopeApiUrl: 'http://dloualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1'
    },
    [RealmID.STAGE]: {
        value: 3,
        name: 'STAGE',
        scopeApiUrl: 'http://sloualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1'
    },
    [RealmID.PROD]: {
        value: 1,
        name: 'PROD',
        scopeApiUrl: 'http://Ploualrtms000.recondo.vci/revenueCycleAlertsService/rcalerts/v1'
    }
};

export interface ErrorResponse {
    error: string;
}

export type ApiResponse = ActivationResponse | ErrorResponse; 