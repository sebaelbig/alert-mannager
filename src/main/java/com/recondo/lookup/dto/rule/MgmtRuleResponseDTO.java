package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MgmtRuleResponseDTO {
    @JsonProperty("count")
    private Integer count;

    @JsonProperty("ruleList")
    private List<InMemoryRuleDTO> ruleList;

    @JsonProperty("totalCount")
    private Integer totalCount;

    @JsonProperty("totalPages")
    private Integer totalPages;

    // Default constructor required for Jackson deserialization
    public MgmtRuleResponseDTO() {
    }

    // Constructor with parameters
    public MgmtRuleResponseDTO(List<InMemoryRuleDTO> filteredRuleList) {
        this.ruleList = filteredRuleList;
        this.count = filteredRuleList.size();
        this.totalCount = filteredRuleList.size();
        this.totalPages = 1;
    }

    // Getters and Setters
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<InMemoryRuleDTO> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<InMemoryRuleDTO> ruleList) {
        this.ruleList = ruleList;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }
}