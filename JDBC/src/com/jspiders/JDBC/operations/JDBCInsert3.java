package com.jspiders.JDBC.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class JDBCInsert3 {
	private static Connection connection;
	private static PreparedStatement preparedStatement;
	private static String query;
	public static void main(String[] args) throws SQLException {
		try {
			openConnection();
		
		
		query = "INSERT INTO user VALUES(?,?,?,?)";
		
		preparedStatement = connection.prepareStatement(query);
		
//		int res = preparedStatement.executeUpdate();
		Scanner scanner = new Scanner(System.in);
		System.out.println("How many records you want to add");
		int count = scanner.nextInt();
		for(int i = 1;i<=count;i++) {
			System.out.println("Enter User Id: ");
			int id = scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter User Name: ");
			String name = scanner.nextLine();
			System.out.println("Enter User Email: ");
			String email = scanner.nextLine();
			System.out.println("Enter User Password: ");
			String pass = scanner.nextLine();
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, name);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, pass);
			preparedStatement.addBatch();
		}
		scanner.close();
		int[] res2 = preparedStatement.executeBatch();
		System.out.println(res2.length+" row(s) affected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			closeConnection();
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
