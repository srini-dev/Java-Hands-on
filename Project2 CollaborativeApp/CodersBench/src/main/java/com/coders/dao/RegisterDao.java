package com.coders.dao;


import java.util.List;

import com.coders.model.Register;

public interface RegisterDao {

	List<Register> getList();
	int saveOrUpdate(Register regi);
	
}
