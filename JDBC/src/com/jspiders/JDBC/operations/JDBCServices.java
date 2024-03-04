package com.jspiders.JDBC.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCServices {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;
	private static String query;
	private static Scanner sc = new Scanner(System.in);
	public static void signUp() {
		
//		System.out.println("SignUp");
		System.out.println("Enter Id:");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name: ");
		String name = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
		
		try {
			openConnection();
			query = "INSERT INTO user VALUES (?,?,?,?)";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2,name);
			preparedStatement.setString(3,email);
			preparedStatement.setString(4,pass);
			int res = preparedStatement.executeUpdate();
			if(res == 1) {
				System.out.println("User Created");
			}
			else {
				System.out.println("trying to call multiple users...");
			}
		} catch (SQLException e) {
			System.out.println("User is alredy Present...\n\n");
//			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				System.out.println("User is alredy Present...");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void logIn(){	
//		System.out.println("LogIn");
//		System.out.println("Enter Id:");
//		int id = sc.nextInt();
//		sc.nextLine();
//		System.out.println("Enter name: ");
//		String name = sc.nextLine();
		System.out.println("Enter Email: ");
		String email = sc.nextLine();
		System.out.println("Enter Password: ");
		String pass = sc.nextLine();
		
		try {
			openConnection();
			query = "SELECT  * FROM user WHERE email = ? AND password = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1,email);
			preparedStatement.setString(2,pass);
			resultSet= preparedStatement.executeQuery();
			
//			resultSet 
//			if() {
//				System.out.println("LoGin Successfull");
//			}
//			else {
//				System.out.println("Ja");
//			}
		} catch (SQLException e) {
//			System.out.println("User is alredy Present...\n\n");
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				System.out.println("User is alredy Present...");
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	}
	private static void closeConnection() throws SQLException {
		if(connection != null) {
			connection.close();
		}
		if(preparedStatement != null) {
			preparedStatement.close();
		}
	}	
}
