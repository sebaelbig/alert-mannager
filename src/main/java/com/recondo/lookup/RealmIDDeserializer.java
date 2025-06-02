package com.recondo.lookup;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;

public class RealmIDDeserializer extends JsonDeserializer<RealmID> {
    @Override
    public RealmID deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        
        // If it's a simple number or string, try to match by value or name
        if (node.isNumber()) {
            int value = node.asInt();
            for (RealmID realm : RealmID.values()) {
                if (realm.getValue() == value) {
                    return realm;
                }
            }
        } else if (node.isTextual()) {
            String name = node.asText();
            return RealmID.valueOf(name);
        }
        
        // If it's an object with realmId field, match by value
        if (node.has("realmId")) {
            int realmId = node.get("realmId").asInt();
            for (RealmID realm : RealmID.values()) {
                if (realm.getValue() == realmId) {
                    return realm;
                }
            }
        }
        
        // If it's an object with name field, match by name
        if (node.has("name")) {
            String name = node.get("name").asText();
            return RealmID.valueOf(name);
        }
        
        throw new IllegalArgumentException("Unable to deserialize RealmID from: " + node.toString());
    }
}