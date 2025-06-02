package com.recondo.lookup.generation.providerInterface.parts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.Size;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PayerPlan implements Serializable {

    @ApiModelProperty(required = false, value = "HIS Payer ID", notes = "Max 100 characters")
    // Nullable
    @Size(max = 100)
    private String hisPayerId;

    @ApiModelProperty(required = false, value = "HIS Payer", notes = "Max 100 characters")
    // Nullable
    @Size(max = 100)
    private String hisPayer;

    @ApiModelProperty(required = false, value = "HIS Plan", notes = "Max 100 characters")
    // Nullable
    @Size(max = 100)
    private String hisPlan;

    // Must have a default constructor for Jackson to use when parsing JSON
    public PayerPlan() {
        super();
    }

    public String getHisPayerId() {
        return hisPayerId;
    }

    public void setHisPayerId(String hisPayerId) {
        this.hisPayerId = hisPayerId;
    }

    public String getHisPayer() {
        return hisPayer;
    }

    public void setHisPayer(String hisPayer) {
        this.hisPayer = hisPayer;
    }

    public String getHisPlan() {
        return hisPlan;
    }

    public void setHisPlan(String hisPlan) {
        this.hisPlan = hisPlan;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
