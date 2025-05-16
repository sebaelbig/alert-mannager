package com.recondo.lookup.service;

import com.recondo.lookup.DatabaseManager;
import com.recondo.lookup.RealmID;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScopeService {

    public int getScopeIdByName(RealmID realmId, String scopeName) {
        return 1;
    }

    private Map<String, String> createErrorResponse(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("message", message);
        return response;
    }
}