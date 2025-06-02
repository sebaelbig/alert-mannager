package com.recondo.lookup.generation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.recondo.lookup.generation.eligibility.X12Response;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class X12AlertRequest implements Serializable {
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

    @ApiModelProperty(required = true, value = "Provider code", notes = "Max 35 characters")
    @NotBlank
    @Size(max = 35)
    private String providerCode;

    @ApiModelProperty(required = true, value = "PayerID")
    @NotNull
    private Integer payerId;

    @ApiModelProperty(required = true, value = "Indicator for Medicare", notes = "boolean")
    @NotNull
    private boolean isMedicare;

    @ApiModelProperty(required = true, value = "Indicator for Medicaid", notes = "boolean")
    @NotNull
    private boolean isMedicaid;


    @ApiModelProperty(required = true, value = "Date of service", notes = "Date object")
    @NotNull
    private Date dateOfService;

    @ApiModelProperty(required = true, value = "X12 as JSON", notes = "X12 Response object")
    @NotNull
    private X12Response x12Response;
}
