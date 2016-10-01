package com.coders.dao;

import java.util.List;

import com.coders.model.BlogMaster;


public interface BlogMasterDao {

	public void SaveOrUpdate(BlogMaster blog);
	
	public List<BlogMaster> list();
	
	public void delete(int id);
	
	public BlogMaster getBlog(int id);
}
