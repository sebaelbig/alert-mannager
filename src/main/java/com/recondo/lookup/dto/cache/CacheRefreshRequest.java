package com.recondo.lookup.dto.cache;

import java.util.List;

public class CacheRefreshRequest {
    private List<Integer> scopeIds;

    // Default constructor
    public CacheRefreshRequest() {
    }

    // Constructor with scopeIds
    public CacheRefreshRequest(List<Integer> scopeIds) {
        this.scopeIds = scopeIds;
    }

    // Getters and setters
    public List<Integer> getScopeIds() {
        return scopeIds;
    }

    public void setScopeIds(List<Integer> scopeIds) {
        this.scopeIds = scopeIds;
    }
} 