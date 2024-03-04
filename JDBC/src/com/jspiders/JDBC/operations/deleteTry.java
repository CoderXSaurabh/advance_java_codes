package com.jspiders.JDBC.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class deleteTry {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter id");
		int id = scanner.nextInt();
		try {
			openConnection();
			query = "DELETE FROM user WHERE id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			int result = preparedStatement.executeUpdate();
			if(result==1) {
				System.out.println("User deleted");
			}else {
				System.out.println("User Not Found");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
		}
	}
	private static void openConnection() throws SQLException, IOException {
		
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	
	}
	private static void closeConnection() throws SQLException {
		if(preparedStatement != null) {
			preparedStatement.close();
		}
		if(connection != null) {
			connection.close();
		}
	}
}