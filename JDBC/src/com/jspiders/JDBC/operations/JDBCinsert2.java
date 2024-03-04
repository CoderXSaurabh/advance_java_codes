package com.jspiders.JDBC.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;



public class JDBCinsert2 {
	private static Driver driver;
	private static Connection connection;
	private static Statement statement;
	private static String query;
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
			query = "Insert INTO user VALUES(3,'SURESH','suresh@gmail.com','Suresh@123')";
			statement.execute(query);
			System.out.println("Date inserted");
		} catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			try {
				closeconnection();
			} catch (SQLException e) {
				e.printStackTrace();

			}
			
		}
		
	}
	private static void openConnection() throws SQLException {
		driver = new com.mysql.cj.jdbc.Driver() ;
		DriverManager.registerDriver(driver);
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4?user=root&&password=root");
	}
	private static void closeconnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		DriverManager.deregisterDriver(driver);
		
	}

}
