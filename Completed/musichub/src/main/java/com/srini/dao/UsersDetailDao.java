package com.srini.dao;

import com.srini.model.MUsersDetail;

import java.util.List;

public interface UsersDetailDao {

	void addUser(MUsersDetail usersDetail);
	MUsersDetail getUserById(int userId);
	List<MUsersDetail> getAllUsers();
	MUsersDetail getUserByUsername(String username);

}
