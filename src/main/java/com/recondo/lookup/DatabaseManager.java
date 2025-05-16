package com.recondo.lookup;
// DatabaseManager.java - Database connection management

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {

    // Datamart DEV
    private static final String DB_DATAMART_DEV_URL = "jdbc:postgresql://dloudb011.recondo.vci:5432/alert_datamart_dev";
    private static final String DB_DATAMART_DEV_USER = "alert_datamart_dev_user";
    private static final String DB_DATAMART_DEV_PASSWORD = "p0j0123";
    // Datamart STAGE
    private static final String DB_DATAMART_STAGE_URL = "jdbc:postgresql://sloudb011.recondo.vci:5432/alert_datamart_stage";
    private static final String DB_DATAMART_STAGE_USER = "alert_datamart_stage_user";
    private static final String DB_DATAMART_STAGE_PASSWORD = "p0j0123";
    // Datamart PROD
    private static final String DB_DATAMART_PROD_URL = "jdbc:postgresql://ploudb014.recondo.vci:5432/alert_datamart_prod";
    private static final String DB_DATAMART_PROD_USER = "alert_datamart_prod_user";
    private static final String DB_DATAMART_PROD_PASSWORD = "d;G#RC3ZbQuL|N";

    // Alert Configuration DEV
    private static final String DB_CONFIGURATION_DEV_URL = "jdbc:postgresql://dloudb011.recondo.vci:5432/alert_configuration_dev";
    private static final String DB_CONFIGURATION_DEV_USER = "alert_configuration_dev_user";
    private static final String DB_CONFIGURATION_DEV_PASSWORD = "p0j0123";
    // Alert Configuration STAGE
    private static final String DB_CONFIGURATION_STAGE_URL = "jdbc:postgresql://sloudb011.recondo.vci:5432/alert_configuration_stage";
    private static final String DB_CONFIGURATION_STAGE_USER = "alert_configuration_stage_user";
    private static final String DB_CONFIGURATION_STAGE_PASSWORD = "p0j0123";
    // Alert Configuration PROD
    private static final String DB_CONFIGURATION_PROD_URL = "jdbc:postgresql://ploudb110.recondo.vci:5432/alert_configuration_prod";
    private static final String DB_CONFIGURATION_PROD_USER = "alert_configuration_prod_user";
    private static final String DB_CONFIGURATION_PROD_PASSWORD = "d;G#RC3ZbQuL|N";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found", e);
        }
    }

    public static Connection getDatamartConnection(RealmID realmID) throws SQLException {
        switch (realmID) {
            case DEV:
                return DriverManager.getConnection(DB_DATAMART_DEV_URL, DB_DATAMART_DEV_USER, DB_DATAMART_DEV_PASSWORD);
            case STAGE:
                return DriverManager.getConnection(DB_DATAMART_STAGE_URL, DB_DATAMART_STAGE_USER, DB_DATAMART_STAGE_PASSWORD);
            case PROD:
                return DriverManager.getConnection(DB_DATAMART_PROD_URL, DB_DATAMART_PROD_USER, DB_DATAMART_PROD_PASSWORD);
            default:
                throw new SQLException("Invalid realm specified for database connection");
        }
    }

    public static Connection getConfigurationConnection(RealmID realmID) throws SQLException {
        switch (realmID) {
            case DEV:
                return DriverManager.getConnection(DB_CONFIGURATION_DEV_URL, DB_CONFIGURATION_DEV_USER, DB_CONFIGURATION_DEV_PASSWORD);
            case STAGE:
                return DriverManager.getConnection(DB_CONFIGURATION_STAGE_URL, DB_CONFIGURATION_STAGE_USER, DB_CONFIGURATION_STAGE_PASSWORD);
            case PROD:
                return DriverManager.getConnection(DB_CONFIGURATION_PROD_URL, DB_CONFIGURATION_PROD_USER, DB_CONFIGURATION_PROD_PASSWORD);
            default:
                throw new SQLException("Invalid realm specified for configuration database connection");
        }
    }
}
