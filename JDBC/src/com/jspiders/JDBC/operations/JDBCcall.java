package com.jspiders.JDBC.operations;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class JDBCcall {
	private static Connection connection;
	private static CallableStatement callableStatement;
	private static String query;
	private static ResultSet resultSet;
	public static void main(String[] args) {
		try {
			openConnection();
			query = "call sort()";
			callableStatement = connection.prepareCall(query);
			callableStatement.execute();
			resultSet = callableStatement.getResultSet();
			while(resultSet.next()) {
				System.out.println(resultSet.getString(2));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
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
	private static void openConnection() throws SQLException {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/weja4","root","root");
	}
	private static void closeConnection() throws SQLException {
		if(connection != null) {
			connection.close();
		}
		if(callableStatement != null) {
			callableStatement.close();
		}
	}
}
