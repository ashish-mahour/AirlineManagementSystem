package com.ams.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ams.dao.api.UserDAO;
import com.ams.entities.UserData;
import com.ams.model.DBConnect;

public class UserDAOImplements implements UserDAO {

	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	UserData userDataGlobal;
	ArrayList<UserData> userDatas;

	public UserDAOImplements() {
		// TODO Auto-generated constructor stub
		statement = DBConnect.getStatement();
		userDatas = new ArrayList<UserData>();
		try {
			statement.execute(
					"CREATE TABLE IF NOT EXISTS USERS_DATA(ID INT AUTO_INCREMENT PRIMARY KEY, USERNAME VARCHAR(200), PASSWORD VARCHAR(200), EMAIL VARCHAR(200), FULL_NAME VARCHAR(200), AGE INT, DOB DATE, ADDRESS VARCHAR(200), CONTACT_NO VARCHAR(200), GENDER VARCHAR(1), USER_TYPE VARCHAR(200), USER_STATUS BIT)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean saveUser(UserData userData) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement(
				"INSERT INTO USERS_DATA (USERNAME, PASSWORD, EMAIL, FULL_NAME, AGE, DOB, ADDRESS, CONTACT_NO, GENDER, USER_TYPE, USER_STATUS) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		try {
			preparedStatement.setString(1, userData.getUserName());
			preparedStatement.setString(2, userData.getPassword());
			preparedStatement.setString(3, userData.getEmail());
			preparedStatement.setString(4, userData.getFullName());
			preparedStatement.setInt(5, userData.getAge());
			preparedStatement.setString(6, userData.getDob());
			preparedStatement.setString(7, userData.getAddress());
			preparedStatement.setString(8, userData.getContactNo());
			preparedStatement.setString(9, userData.getGender());
			preparedStatement.setString(10, userData.getUserType());
			preparedStatement.setBoolean(11, userData.getUserStatus());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateUser(UserData userData, String username) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("DELETE FROM USERS_DATA WHERE USERNAME = ?");
		try {
			preparedStatement.setString(1, username);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		saveUser(userData);
		return true;
	}

	@Override
	public boolean deleteUser(String username) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("DELETE FROM USERS_DATA WHERE USERNAME = ?");
		try {
			preparedStatement.setString(1, username);
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public UserData getUserByUsername(String username) {
		preparedStatement = DBConnect.getPreparedStatement("SELECT * FROM USERS_DATA WHERE USERNAME = ?");
		try {
			preparedStatement.setString(1, username);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userDataGlobal.setId(resultSet.getInt(1));
				userDataGlobal.setUserName(resultSet.getString(1));
				userDataGlobal.setPassword(resultSet.getString(2));
				userDataGlobal.setEmail(resultSet.getString(3));
				userDataGlobal.setFullName(resultSet.getString(4));
				userDataGlobal.setAge(resultSet.getInt(5));
				userDataGlobal.setDob(resultSet.getString(7));
				userDataGlobal.setAddress(resultSet.getString(8));
				userDataGlobal.setContactNo(resultSet.getString(9));
				userDataGlobal.setGender(resultSet.getString(10));
				userDataGlobal.setUserType(resultSet.getString(11));
			} else {
				userDataGlobal = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDataGlobal;
	}

	@Override
	public UserData getUserByEmail(String email) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("SELECT * FROM USERS_DATA WHERE EMAIL = ?");
		try {
			preparedStatement.setString(1, email);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				userDataGlobal.setId(resultSet.getInt(1));
				userDataGlobal.setUserName(resultSet.getString(1));
				userDataGlobal.setPassword(resultSet.getString(2));
				userDataGlobal.setEmail(resultSet.getString(3));
				userDataGlobal.setFullName(resultSet.getString(4));
				userDataGlobal.setAge(resultSet.getInt(5));
				userDataGlobal.setDob(resultSet.getString(7));
				userDataGlobal.setAddress(resultSet.getString(8));
				userDataGlobal.setContactNo(resultSet.getString(9));
				userDataGlobal.setGender(resultSet.getString(10));
				userDataGlobal.setUserType(resultSet.getString(11));
			} else {
				userDataGlobal = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userDataGlobal;
	}

	@Override
	public ArrayList<UserData> getAll() {
		statement = DBConnect.getStatement();
		try {
			resultSet = statement.executeQuery("SELECT * FROM USERS_DATA");
			while (resultSet.next()) {
				userDatas.add(new UserData());
				userDatas.get(userDatas.size() - 1).setId(resultSet.getInt(1));
				userDatas.get(userDatas.size() - 1).setUserName(resultSet.getString(2));
				userDatas.get(userDatas.size() - 1).setPassword(resultSet.getString(3));
				userDatas.get(userDatas.size() - 1).setEmail(resultSet.getString(4));
				userDatas.get(userDatas.size() - 1).setFullName(resultSet.getString(5));
				userDatas.get(userDatas.size() - 1).setAge(resultSet.getInt(6));
				userDatas.get(userDatas.size() - 1).setDob(resultSet.getString(7));
				userDatas.get(userDatas.size() - 1).setAddress(resultSet.getString(8));
				userDatas.get(userDatas.size() - 1).setContactNo(resultSet.getString(9));
				userDatas.get(userDatas.size() - 1).setGender(resultSet.getString(10));
				userDatas.get(userDatas.size() - 1).setUserType(resultSet.getString(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userDatas;
	}

}
