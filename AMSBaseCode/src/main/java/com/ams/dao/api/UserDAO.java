package com.ams.dao.api;

import java.util.ArrayList;

import com.ams.entities.UserData;

public interface UserDAO {
	public boolean saveUser(UserData userData);

	public boolean updateUser(UserData userData, int id);

	public boolean deleteUser(String username);

	public UserData getUserByUsername(String username);

	public UserData getUserByEmail(String email);

	public ArrayList<UserData> getAll();
}
