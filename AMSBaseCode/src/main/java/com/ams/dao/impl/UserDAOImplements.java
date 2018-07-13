package com.ams.dao.impl;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.ams.dao.api.UserDAO;
import com.ams.entities.UserData;
import com.ams.model.DBConnect;

public class UserDAOImplements implements UserDAO {
	
	Statement statement;
	PreparedStatement preparedStatement;
	SimpleDateFormat simpleDateFormat;
	

	public UserDAOImplements() {
		// TODO Auto-generated constructor stub
		statement = DBConnect.getStatement();
		simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			statement.execute(
					"CREATE TABLE IF NOT EXISTS USERS_DATA(ID INT AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(200), PASSWORD VARCHAR(200), EMAIL VARCHAR(200), FULL_NAME VARCHAR(200), AGE INT, DOB DATE, ADDRESS VARCHAR(200), CONTACT_NO NUMERIC(15), GENDER VARCHAR(1), USER_TYPE VARCHAR(200))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean saveUser(UserData userData) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("INSERT INTO USERS_DATA (USERNAME, PASSWORD, EMAIL, FULL_NAME, AGE, DOB, ADDRESS, CONTACT_NO, GENDER, USER_TYPE) VALUES (?,?,?,?,?,?,?,?,?,?)");
		try {
			preparedStatement.setString(1, userData.getUserName());
			preparedStatement.setString(2, userData.getPassword());
			preparedStatement.setString(3, userData.getEmail());
			preparedStatement.setString(4, userData.getFullName());
			preparedStatement.setInt(5, userData.getAge());
			preparedStatement.setString(6, simpleDateFormat.format(userData.getDob()));
			preparedStatement.setString(7, userData.getAddress());
			preparedStatement.setLong(8, userData.getContactNo());
			preparedStatement.setString(9, userData.getGender());
			preparedStatement.setString(10, userData.getUserType());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateUser(UserData userData, int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserData getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserData getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<UserData> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
