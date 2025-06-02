package com.recondo.lookup.dto.activation;

import java.util.List;

public class ActivationResponse {
    private List<Activation> activations;
    private int count;
    private int totalCount;
    private int totalPages;

    public List<Activation> getActivations() { return activations; }
    public void setActivations(List<Activation> activations) { this.activations = activations; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public int getTotalCount() { return totalCount; }
    public void setTotalCount(int totalCount) { this.totalCount = totalCount; }

    public int getTotalPages() { return totalPages; }
    public void setTotalPages(int totalPages) { this.totalPages = totalPages; }
}