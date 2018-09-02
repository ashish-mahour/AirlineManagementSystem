package com.ams.entities;

public class LocationData {
	private int id;
	private String locationName;
	private String locationCode;

	public LocationData(int id, String locationName, String locationCode) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.locationCode = locationCode;
	}

	public LocationData() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationCode() {
		return locationCode;
	}

	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
}
