package com.ams.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ams.dao.api.FlightDAO;
import com.ams.entities.FlightsData;
import com.ams.model.DBConnect;

public class FlightDAOImpl implements FlightDAO {

	private Statement statement;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	private FlightsData flightsData = null;
	private ArrayList<FlightsData> flightsDatas = new ArrayList<FlightsData>();

	public FlightDAOImpl() {
		// TODO Auto-generated constructor stub
		statement = DBConnect.getStatement();
		try {
			statement.execute(
					"CREATE TABLE IF NOT EXISTS FLIGHT_DATA (ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(200), ARRIVAL_CODE VARCHAR(20), DESINATION_CODE VARCHAR(20), ARRIVAL_TIME VARCHAR(20), DESTINATION_TIME VARCHAR(20), SEATS_AVAILABLE INT)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public boolean addFlight(FlightsData flightsData) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement(
				"INSERT INTO FLIGHT_DATA(NAME, ARRIVAL_CODE, DESINATION_CODE, ARRIVAL_TIME, DESTINATION_TIME, SEATS_AVAILABLE) VALUES(?,?,?,?,?,?,?)");
		try {
			preparedStatement.setString(1, flightsData.getFlightName());
			preparedStatement.setString(2, flightsData.getFlightArrival());
			preparedStatement.setString(3, flightsData.getFlightDestination());
			preparedStatement.setString(4, flightsData.getArrivalTime());
			preparedStatement.setString(5, flightsData.getDestinationTime());
			preparedStatement.setInt(6, flightsData.getSeatsAvailable());
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean modifyFlight(String flightName, FlightsData flightsData) {
		// TODO Auto-generated method stub
		deleteFlight(flightName);
		addFlight(flightsData);
		return true;
	}

	@Override
	public boolean deleteFlight(String flightName) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("DELETE FROM FLIGHT_DATA WHERE NAME = ?");
		try {
			preparedStatement.setString(1, flightName);
			preparedStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public FlightsData getOne(String flightName) {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("SELECT * FROM FLIGHT_DATA WHERE NAME = ?");
		try {
			preparedStatement.setString(1, flightName);
			resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				flightsData = new FlightsData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flightsData;
	}

	@Override
	public ArrayList<FlightsData> getALL() {
		// TODO Auto-generated method stub
		preparedStatement = DBConnect.getPreparedStatement("SELECT * FROM FLIGHT_DATA");
		try {
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				 flightsDatas.add(new FlightsData(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3),
						resultSet.getString(4), resultSet.getString(5), resultSet.getString(6), resultSet.getInt(7)));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flightsDatas;
	}

	@Override
	public ArrayList<FlightsData> getByTimeAndPlace(String arrivalPlace, String destinationPlace, String arrivalTime,
			String destinationTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
