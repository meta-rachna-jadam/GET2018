package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.model.CustemException;

public class JDBCConnection {
 
	public static Connection getConnection(String databaseName, String uername, String password) {
	    Connection connectionInstance = null;
	    try {
	      Class.forName("com.mysql.jdbc.Driver");
	      String url = "jdbc:mysql://localhost:3306/"+ databaseName;
	      connectionInstance = DriverManager.getConnection(url, uername , password);
	    } catch (ClassNotFoundException classNotFoundException) {
	    	new CustemException("JDBCConnection", classNotFoundException.toString(), classNotFoundException.getMessage());
	        System.exit(1);
	    } catch (SQLException sqlException) {
	    	new CustemException("JDBCConnection", sqlException.toString(), sqlException.getMessage());
	      System.exit(2);
	    } catch (Exception exception) {
	    	new CustemException("JDBCConnection", exception.toString(), exception.getMessage());
		    System.exit(2);
		}
	    return connectionInstance;
	  }
}
