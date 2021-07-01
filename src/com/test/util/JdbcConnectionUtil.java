package com.test.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionUtil {

    static String dbURL = "jdbc:mysql://localhost:3306/world";
    static String username = "root";
    static String password = "megaroot";

    public static Connection getJdbcConnection(){
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn != null) {
                System.out.println ( "Connected" );
                return conn;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    return null;
    }


}
