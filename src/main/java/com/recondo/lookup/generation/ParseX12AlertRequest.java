package com.recondo.lookup.generation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ParseX12AlertRequest {
    private static final long serialVersionUID = 0L;

    @ApiModelProperty(required = true, value = "Realm ID", notes = "Integer PROD=1|2, STAGE=3, TEST=4")
    @NotNull
    private Integer realmId;

    @ApiModelProperty(value = "Waystar Customer ID", notes = "Integer")
    //Nullable
    private Integer customerId;

    @ApiModelProperty(required = true, value = "Provider code", notes = "Max 35 characters")
    @NotBlank
    @Size(max = 35)
    private String providerCode;

    @ApiModelProperty(required = true, value = "REC PayerID")
    @NotNull
    private String recoPayerId;

    @ApiModelProperty(required = true, value = "X12 as String", notes = "X12 Response string")
    @NotNull
    private String x12Response;
}
