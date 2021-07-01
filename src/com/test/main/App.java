package com.test.main;

import com.test.util.JdbcConnectionUtil;

import java.sql.*;

public class App {

    public static int insertData() throws SQLException {
        String sql = "INSERT INTO Users (username, password, fullname, email) VALUES (?, ?, ?, ?)";

        Connection conn = JdbcConnectionUtil.getJdbcConnection ();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "anubhav");
        statement.setString(2, "secretpass");
        statement.setString(3, "Anubhav");
        statement.setString(4, "anubhav@gmail.com");

        int rowsInserted = statement.executeUpdate();
        if (rowsInserted > 0) {
            System.out.println("A new user was inserted successfully!");
        }
        return rowsInserted;
    }

    public static void readData() throws SQLException {
        String sql = "SELECT * FROM Users";
        Connection conn = JdbcConnectionUtil.getJdbcConnection ();
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);

        int count = 0;

        while (result.next()){
            String name = result.getString("username");
            String pass = result.getString("password");
            String fullname = result.getString("fullname");
            String email = result.getString("email");

            String output = "User #%d: %s - %s - %s - %s";
            System.out.println(String.format(output, ++count, name, pass, fullname, email));
        }
    }

    public static void updateData(String fullname, String username) throws SQLException {
        String sql = "UPDATE Users SET fullname=? WHERE username=?";
        Connection conn = JdbcConnectionUtil.getJdbcConnection ();
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, fullname);
        statement.setString(2, username);

        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("An existing user was updated successfully!");
        }
    }

    public static void deleteData(String username) throws SQLException {
        String sql = "DELETE FROM Users WHERE username=?";
        Connection conn = JdbcConnectionUtil.getJdbcConnection ();
        PreparedStatement statement = conn.prepareStatement ( sql );
        statement.setString ( 1, username );

        int rowsDeleted = statement.executeUpdate ();
        if (rowsDeleted > 0) {
            System.out.println ( "A user was deleted successfully!" );
        }
    }

    public static void main ( String[] args ) {
        try {
            //insertData ();
            //deleteData ( "anubhav" );
            updateData ( "Sameer" , "sameer");
            readData();
        } catch (SQLException throwables) {
            throwables.printStackTrace ();
        }

    }
}
