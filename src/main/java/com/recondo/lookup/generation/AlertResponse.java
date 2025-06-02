package com.recondo.lookup.generation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertResponse extends GenericAlertResponse {

	@ApiModelProperty(required = true, value = "Transaction ID", notes = "UUID")
	@NotNull
	private UUID transactionId;

	@ApiModelProperty(required = true, value = "Source host", notes = "Max 64 characters")
	@NotBlank
	@Size(max = 64)
	private String host;

	@ApiModelProperty(required = true, value = "Encounter RID", notes = "UUID")
	@NotNull
	private UUID encounterRid;


	@ApiModelProperty(required = false, value = "Hide Account", notes = "Boolean")
	@NotNull
	private Boolean hideAccount;

	// Must have a default constructor for Jackson to use when parsing JSON
	public AlertResponse() {
		super();
	}
}
