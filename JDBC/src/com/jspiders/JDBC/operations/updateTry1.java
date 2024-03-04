package com.jspiders.JDBC.operations;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class updateTry1 {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
//	private static ResultSet resultSet;
	private static String query;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Id of the user");
		int id = scanner.nextInt();
		System.out.println("Enter New Password");
		String pass = scanner.next();
		scanner.close();
		
		try {
			openConnection();
			
			query = "UPDATE user SET password=? WHERE id = ?";
			
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, pass);
			preparedStatement.setInt(2, id);
			int res = preparedStatement.executeUpdate();
			if(res==1) {
				System.out.println("User Updated");
			}else {
				System.out.println("User Not found");
			}
//			System.out.println("name updated");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
