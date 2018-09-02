package com.ams.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.ams.dao.api.LocationDAO;
import com.ams.entities.LocationData;
import com.ams.model.DBConnect;

public class LocationDAOImpl implements LocationDAO {

	Statement statement;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	ArrayList<LocationData> locationDatas;
	LocationData locationData;

	public LocationDAOImpl() {
		// TODO Auto-generated constructor stub
		locationDatas = new ArrayList<LocationData>();
		statement = DBConnect.getStatement();
		try {
			statement.execute(
					"CREATE TABLE IF NOT EXISTS LOCATION_DATA (ID INT PRIMARY KEY AUTO_INCREMENT, LOCATION_NAME VARCHAR(200), LOCATION_CODE VARCHAR(20))");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean saveLocation(LocationData locationData) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect
				.getPreparedStatement("INSERT INTO LOCATION_DATA (LOCATION_NAME,LOCATION_CODE) VALUES (?,?)");
		try {
			preparedStatement.setString(1, locationData.getLocationName());
			preparedStatement.setString(2, locationData.getLocationCode());
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean updateLocation(LocationData locationData, String locationCode) {
		// TODO Auto-generated method stub
		deleteLocation(locationCode);
		saveLocation(locationData);
		return false;
	}

	@Override
	public boolean deleteLocation(String locationCode) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("DELETE FROM LOCATION_DATA WHERE LOCATION_CODE = ?");
		try {
			preparedStatement.setString(1, locationCode);
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public ArrayList<LocationData> getAllLocation() {
		// TODO Auto-generated method stub
		statement = DBConnect.getStatement();
		try {
			resultSet = statement.executeQuery("SELECT * FROM LOCATION_DATA");
			while (resultSet.next()) {
				locationDatas
						.add(new LocationData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return locationDatas;
	}

	@Override
	public LocationData getLocationByCode(String locationCode) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect
				.getPreparedStatement("SELECT * FROM LOCATION_DATA WHERE LOCATION_CODE = ? LIMIT 1");
		try {
			preparedStatement.setString(1, locationCode);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				locationData = new LocationData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3));
			} else {
				locationData = null;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return locationData;
	}

}
