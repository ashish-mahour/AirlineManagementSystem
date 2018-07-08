package com.ams.dao.impl;

import java.util.ArrayList;

import com.ams.dao.api.UserDAO;
import com.ams.entities.UserData;

public class UserDAOImplements implements UserDAO {

	@Override
	public boolean saveUser(UserData userData) {
		// TODO Auto-generated method stub
		return false;
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
