package com.ams.entities;

public class FlightsData {
	private int id;
	private String flightName;
	private String flightArrival;
	private String flightDestination;
	private String arrivalTime;
	private String destinationTime;
	private int seatsAvailable;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getFlightArrival() {
		return flightArrival;
	}

	public void setFlightArrival(String flightArrival) {
		this.flightArrival = flightArrival;
	}

	public String getFlightDestination() {
		return flightDestination;
	}

	public void setFlightDestination(String flightDestination) {
		this.flightDestination = flightDestination;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDestinationTime() {
		return destinationTime;
	}

	public void setDestinationTime(String destinationTime) {
		this.destinationTime = destinationTime;
	}

	public int getSeatsAvailable() {
		return seatsAvailable;
	}

	public void setSeatsAvailable(int seatsAvailable) {
		this.seatsAvailable = seatsAvailable;
	}

	public FlightsData(int id, String flightName, String flightArrival, String flightDestination, String arrivalTime,
			String destinationTime, int seatsAvailable) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.flightArrival = flightArrival;
		this.flightDestination = flightDestination;
		this.arrivalTime = arrivalTime;
		this.destinationTime = destinationTime;
		this.seatsAvailable = seatsAvailable;
	}

}
