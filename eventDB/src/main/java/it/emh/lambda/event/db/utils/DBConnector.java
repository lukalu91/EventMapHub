package it.emh.lambda.event.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String db_database = "";
    private static String db_hostname = "";
    private static String db_username = "";
    private static String db_password = "";
    private static String db_protocol = "";
    private static String db_port = "";

    private static DBConnector _instance = null;


    private DBConnector() throws Exception {
        db_database = PropertiesManager.getInstance().getProperties(EProperties.DB_NAME);
        db_hostname = PropertiesManager.getInstance().getProperties(EProperties.DB_HOSTNAME);
        db_username = PropertiesManager.getInstance().getProperties(EProperties.DB_USERNAME);
        db_password = PropertiesManager.getInstance().getProperties(EProperties.DB_PASSWORD);
        db_protocol = PropertiesManager.getInstance().getProperties(EProperties.DB_PROTOCOL);
        db_port = PropertiesManager.getInstance().getProperties(EProperties.DB_PORT);
    }

    public static synchronized DBConnector getInstance() throws Exception {
        if (_instance == null) {
            _instance = new DBConnector();
        }

        return _instance;
    }

    public Connection getConnection(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(db_protocol+"//"+db_hostname+":"+db_port+"/"+db_database, db_username, db_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
