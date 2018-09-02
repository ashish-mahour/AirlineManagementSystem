package com.ams.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	private static Connection getLocalConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlinemanagementsystem?autoReconnect=true&useSSL=false", "root", "ashu");

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Statement getStatement() {
		Statement statement = null;
		try {
			statement = getLocalConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}

	public static PreparedStatement getPreparedStatement(String sqlQuery) {
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = getLocalConnection().prepareStatement(sqlQuery);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return preparedStatement;
	}

}
