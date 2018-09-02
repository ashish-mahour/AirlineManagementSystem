package com.ams.dao.api;

import java.util.ArrayList;

import com.ams.entities.LocationData;

public interface LocationDAO {
	public boolean saveLocation(LocationData locationData);
	public boolean updateLocation(LocationData locationData, String locationCode);
	public boolean deleteLocation(String locationCode);
	public ArrayList<LocationData> getAllLocation();
	public LocationData getLocationByCode(String locationCode);
	
}
