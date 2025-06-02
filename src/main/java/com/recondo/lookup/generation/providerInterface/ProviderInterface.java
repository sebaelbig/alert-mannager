package com.recondo.lookup.generation.providerInterface;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.recondo.lookup.generation.providerInterface.parts.PayerPlan;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProviderInterface implements Serializable {

    @ApiModelProperty(required = false, value = "Provider Interface Payer Plan")
    @NotNull
    private PayerPlan payerPlan;

    // Must have a default constructor for Jackson to use when parsing JSON
    public ProviderInterface() {
        super();
    }

    public PayerPlan getPayerPlan() {
        return payerPlan;
    }

    public void setPayerPlan(PayerPlan payerPlan) {
        this.payerPlan = payerPlan;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
