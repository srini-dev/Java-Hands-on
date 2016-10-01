package com.coders.dao;

import java.util.List;

import com.coders.model.BlogMaster;
import com.coders.model.Users;

public interface UsersDao {

	List<Users> getAllUser();
	public Users getUsr(String uid,String pwd);
	public void SaveOrUpdate(Users usr);
	public void delete(int id);
}
