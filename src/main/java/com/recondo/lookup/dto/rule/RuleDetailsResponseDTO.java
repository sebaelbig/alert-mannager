package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RuleDetailsResponseDTO {
    private List<RuleDetailsDTO> rules;
    private String error;

    public List<RuleDetailsDTO> getRules() {
        return rules;
    }

    public void setRules(List<RuleDetailsDTO> rules) {
        this.rules = rules;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}