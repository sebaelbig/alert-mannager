package com.recondo.lookup.generation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GenericAlertResponse implements Serializable {
    private static final long serialVersionUID = 0L;

    @ApiModelProperty(required = false, value = "Alerts generated from processing", notes = "List of GeneratedAlerts")
    // Nullable
    private List<GeneratedAlert> generatedAlerts = new ArrayList<>();


    // Must have a default constructor for Jackson to use when parsing JSON
    public GenericAlertResponse() {
        super();
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }
}
