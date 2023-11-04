package com.tmf.students.backend.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfig {
	private static Connection con;
	
	public static Connection connectDB() {
		try {
			//Finding the driver in the attached jar file.
			//Driver is a java class file.
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver has been connected successfully");
			
			String url = "jdbc:mysql://localhost:3306/tmfdb";
			String username = "root";
			String password = "root";
			//connecting with the database.
			con = DriverManager.getConnection(url, username, password);
			
			System.out.println("Connected with the database");
			
		} catch (ClassNotFoundException e) {
			System.out.println("Driver not found..");
		} catch(SQLException e) {
			System.out.println("Unable to execute command");
		}
		return con;
	}
}
