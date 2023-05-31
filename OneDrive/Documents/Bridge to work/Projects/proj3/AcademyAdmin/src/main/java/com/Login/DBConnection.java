package com.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	protected static Connection initializeDatabase() throws ClassNotFoundException, SQLException {
		
		String  dbDriver = "com.mysql.cj.jdbc.Driver";
		String  dbURL = "jdbc:mysql://localhost:3306/learnacademy?"+"useSSL=false";
		
		//String dbName = "vit";
		String dbUsername = "root";
		String dbPassword = "RuethS54%sO$";//change this according to your password 
		
		Class.forName(dbDriver);
		System.out.println("Driver loaded successfully !");
		
		Connection con = DriverManager.getConnection(dbURL, dbUsername, dbPassword);
		
		return con;
		
		
	}

}
