import { DatamartDTO, AlertRequest, AlertResponse, EligibilityResponse } from './datamart.interface';

export const mockEligibilityResponse: EligibilityResponse = {
  header: {
    senderId: 'SENDER123',
    recvId: 'RECEIVER456',
    interchangeTimeStamp: new Date().toISOString()
  },
  payer: {
    lastName: 'Test Payer',
    idCode: 'PAY123'
  },
  subscriber: {
    firstName: 'John',
    lastName: 'Doe',
    idCode: 'SUB789',
    indRelCode: '01'
  },
  benefits: [
    {
      benefitType: 'Medical',
      coverageLevel: 'Family',
      serviceTypes: ['Emergency', 'Routine'],
      msgs: ['Coverage active', 'No restrictions'],
      planNetwork: 'PPO',
      percentage: 0.8,
      amount: 1000,
      dates: [
        {
          datePeriodQlfr: 'Coverage',
          startDate: '2024-01-01',
          endDate: '2024-12-31'
        }
      ]
    }
  ]
};

export const mockAlertRequest: AlertRequest = {
  host: 'test-host',
  realmId: 1,
  customerId: 12345,
  encounterRid: '550e8400-e29b-41d4-a716-446655440000',
  providerCode: 'PROV123',
  regionCode: 'REG001',
  recoPayerId: 'PAY456',
  isSpv: false,
  isMedicare: false,
  isMedicaid: false,
  isOutOfNetwork: false,
  memberNumber: 'MEM123',
  enteredMemberNumber: 'MEM123',
  groupNumber: 'GRP456',
  genderCode: 'F',
  subscriberRelationship: 'Self',
  eligibilityResponse: mockEligibilityResponse
};

export const mockAlertResponse: AlertResponse = {
  transactionId: '550e8400-e29b-41d4-a716-446655440001',
  host: 'test-host',
  encounterRid: '550e8400-e29b-41d4-a716-446655440000',
  hideAccount: false,
  generatedAlerts: []
};

export const mockDatamartDTO: DatamartDTO = {
  requestBody: mockAlertRequest,
  requestBodyJSON: JSON.stringify(mockAlertRequest),
  responseBody: mockAlertResponse
};