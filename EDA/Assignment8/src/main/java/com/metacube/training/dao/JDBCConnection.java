package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.metacube.training.model.CustomException;

public class JDBCConnection {
 
    public static Connection getConnection(String databaseName, String uername, String password) {

        Connection connectionInstance = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"+ databaseName;
            connectionInstance = DriverManager.getConnection(url, uername , password);
        } catch (ClassNotFoundException classNotFoundException) {
        	new CustomException("JDBCConnection", classNotFoundException.toString(), classNotFoundException.getMessage());
            classNotFoundException.printStackTrace();
            System.exit(1);
        } catch (SQLException sqlException) {
        	new CustomException("JDBCConnection", sqlException.toString(), sqlException.getMessage());
            sqlException.printStackTrace();
            System.exit(2);
        }
        return connectionInstance;
    }
}
