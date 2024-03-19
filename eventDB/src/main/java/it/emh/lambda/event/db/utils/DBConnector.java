package it.emh.lambda.event.db.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static final String db_database = "";
    private static final String db_hostname = "";
    private static final String db_username = "";
    private static final String db_password = "";
    private static final String db_protocol = "";
    private static final String db_port = "";


    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(db_protocol+"//"+db_hostname+":"+db_port+"/"+db_database, db_username, db_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
