package com.recondo.lookup.generation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.recondo.lookup.generation.eligibility.EligibilityResponse;
import com.recondo.lookup.generation.providerInterface.ProviderInterface;
// import com.recondo.lookup.generation.providerInterface.ProviderInterface;
// import com.recondo.lookup.utils.validation.HostConsistency;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

// @HostConsistency
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class AlertRequest implements Serializable {
	private static final long serialVersionUID = 0L;

	@ApiModelProperty(value = "Source host", notes = "Max 64 characters, required if realmId and customerId are null")
	//Nullable
	@Size(max = 64)
	private String host;

	@ApiModelProperty(value = "Realm ID", notes = "Integer PROD=1|2, STAGE=3, TEST=4, required if host is null")
	//Nullable
	private Integer realmId;

	@ApiModelProperty(value = "OIT Customer ID", notes = "Integer, required if host is null")
	//Nullable
	private Integer customerId;

	@ApiModelProperty(required = true, value = "Encounter RID", notes = "UUID")
	@NotNull
	private UUID encounterRid;

	@ApiModelProperty(required = true, value = "Provider code", notes = "Max 35 characters")
	@NotBlank
	@Size(max = 35)
	private String providerCode;

	@ApiModelProperty(required = true, value = "Region code", notes = "Max 35 characters")
	@Size(max = 35)
	private String regionCode;

	@ApiModelProperty(required = true, value = "RecoPayerID", notes = "Max 35 characters")
	@NotBlank
	@Size(max = 35)
	private String recoPayerId;

	@ApiModelProperty(required = true, value = "Indicator for Self Pay", notes = "boolean")
	@NotNull
	private boolean isSpv;

	@ApiModelProperty(required = true, value = "Indicator for Medicare", notes = "boolean")
	@NotNull
	private boolean isMedicare;

	@ApiModelProperty(required = true, value = "Indicator for Medicaid", notes = "boolean")
	@NotNull
	private boolean isMedicaid;

	@ApiModelProperty(value = "Indicator for Out of Network Payers", notes = "boolean")
	// Nullable
	private boolean isOutOfNetwork;

	@ApiModelProperty(required = true, value = "Member number", notes = "Max 50 characters")
	// Nullable
	@Size(max = 50)
	private String memberNumber;

	@ApiModelProperty(value = "Entered Member number", notes = "Max 50 characters")
	// Nullable
	@Size(max = 50)
	private String enteredMemberNumber;

	@ApiModelProperty(value = "Group number", notes = "Max 50 characters")
	// Nullable
	@Size(max = 50)
	private String groupNumber;

	@ApiModelProperty(value = "Gender Code", notes = "Max 50 characters")
	// Nullable
	@Size(max = 50)
	private String genderCode;

	@ApiModelProperty(value = "Subscriber Relationship", notes = "Max 50 characters")
	// Nullable
	@Size(max = 50)
	private String subscriberRelationship;

	@ApiModelProperty(value = "Patient type", notes = "Max 65 characters")
	// Nullable
	@Size(max = 65)
	private String patientType;

	@ApiModelProperty(value = "Medical service", notes = "Max 100 characters")
	// Nullable
	@Size(max = 100)
	private String medicalService;

	@ApiModelProperty(value = "270 Patient State", notes = "Max 2 characters")
	// Nullable
	@Size(min = 2, max = 2)
	private String patientState;

	@ApiModelProperty(value = "270 Patient Zip", notes = "Max 15 characters")
	// Nullable
	@Size(min = 3, max = 15)
	private String patientZip;

	@ApiModelProperty(required = true, value = "Date of service", notes = "Date object")
	@NotNull
	private Date dateOfService;

	@ApiModelProperty( value = "Date of birth", notes = "Date object")
	// Nullable
	private Date dateOfBirth;

	@ApiModelProperty(required = false, value = "Provider Interface")
	// Nullable
	private ProviderInterface providerInterface;

	@ApiModelProperty(required = true, value = "271 from PRS as JSON", notes = "EligibilityResponse object")
	@NotNull
	private EligibilityResponse eligibilityResponse;

	@ApiModelProperty(required = false, value = "Revenue Codes")
	private List<String> revenueCodes;

	@ApiModelProperty(required = false, value = "Procedure Codes")
	private List<String> procedureCodes;
	//Revenue Code
	//Procedure Code

	// Must have a default constructor for Jackson to use when parsing JSON
	public AlertRequest() {
		super();
	}

	@JsonProperty("isSpv")
	public void setSpv(boolean spv) {
		isSpv = spv;
	}

	@JsonProperty("isMedicare")
	public void setMedicare(boolean medicare) {
		isMedicare = medicare;
	}

	@JsonProperty("isMedicaid")
	public void setMedicaid(boolean medicaid) {
		isMedicaid = medicaid;
	}

	@JsonProperty("isOutOfNetwork")
	public void setOutOfNetwork(boolean outOfNetwork) {
		isOutOfNetwork = outOfNetwork;
	}
}
