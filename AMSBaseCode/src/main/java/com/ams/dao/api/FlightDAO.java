package com.ams.dao.api;

import java.util.ArrayList;

import com.ams.entities.FlightsData;

public interface FlightDAO {
	public boolean addFlight(FlightsData flightsData);

	public boolean modifyFlight(String flightName, FlightsData flightsData);

	public boolean deleteFlight(String flightName);

	public FlightsData getOne(String flightName);

	public ArrayList<FlightsData> getALL();

	public ArrayList<FlightsData> getByTimeAndPlace(String arrivalPlace, String destinationPlace, String arrivalTime,
			String destinationTime);
}
