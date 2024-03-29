package com.jspiders.JDBC.operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCselect {
	private static Connection connection;
	private static Statement statement;
	private static String query;
	private static ResultSet resultSet;
	public static void main(String[] args) {
		try {
			openConnection();
			statement = connection.createStatement();
			query = "select * from user";
			statement.execute(query);
			resultSet = statement.getResultSet();
//			System.out.println(resultSet.next()); resultSet.next() return boolean value if it called
			while(resultSet.next()) {
				System.out.print(" "+resultSet.getInt(1));
				System.out.print(" "+resultSet.getString(2));
				System.out.print(" \t"+resultSet.getString(3));
				System.out.println(" \t"+resultSet.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				closeConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	private static void openConnection() throws SQLException{
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	}
	private static void closeConnection() throws SQLException {
		if(statement != null) {
			statement.close();
		}
		if(connection != null) {
			connection.close();
		}
		
	}
}
