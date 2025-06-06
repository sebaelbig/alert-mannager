package com.recondo.lookup.dto.rule;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.recondo.lookup.RealmID;

public class CreateRuleDTO {
  private RealmID realm;
  private int scopeId;
  private String username;
  private String rule;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  public RealmID getRealm() {
    return realm;
  }

  public void setRealm(RealmID realm) {
    this.realm = realm;
  }

  public int getScopeId() {
    return scopeId;
  }

  public void setScopeId(int scopeId) {
    this.scopeId = scopeId;
  }

  public String getRule() {
    return rule;
  }

  public void setRule(String rule) {
    this.rule = rule;
  }

  @JsonCreator
  public static RealmID fromValue(int value) {
    for (RealmID realm : RealmID.values()) {
      if (realm.getValue() == value) {
        return realm;
      }
    }
    throw new IllegalArgumentException("Invalid realm value: " + value);
  }
}
