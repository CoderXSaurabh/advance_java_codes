package com.jspiders.JDBC.operations;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsert {
public static void main(String[] args) throws SQLException {
	// Load and Register the driver 
	Driver driver = new com.mysql.cj.jdbc.Driver(); // Upcasting 
	DriverManager.registerDriver(driver);
	
	// Open connection
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
	
	// Create the statement
	 Statement statement = connection.createStatement();
	 
	 // Execute the Statement
	 statement.execute("INSERT INTO user VALUES(2,'Saurabh','patilsaurabh5122001@gmail.com','Saurabh123')");
//	 statement.execute("UPDATE user VALUES SET ('SP')");
	 // Process the result 
	 System.out.println("Data Inserted");
	 
	 // close the connection 
	 statement.close();
	 connection.close();
	 
	 // De-register the Driver
	 DriverManager.deregisterDriver(driver);
}
}
