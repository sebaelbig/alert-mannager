package com.recondo.lookup.dto.activation;

import java.util.List;

import com.recondo.lookup.RealmID;

public class Activation {
    private List<ActivationEntity> activationEntities;
    private List<RealmID> activeRealms;
    private int count;
    private int id;
    private String name;

    public List<ActivationEntity> getActivationEntities() { return activationEntities; }
    public void setActivationEntities(List<ActivationEntity> activationEntities) { this.activationEntities = activationEntities; }

    public List<RealmID> getActiveRealms() { return activeRealms; }
    public void setActiveRealms(List<RealmID> activeRealms) { this.activeRealms = activeRealms; }

    public int getCount() { return count; }
    public void setCount(int count) { this.count = count; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
}