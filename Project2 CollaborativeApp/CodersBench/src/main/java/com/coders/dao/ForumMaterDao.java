package com.coders.dao;

import java.util.List;


import com.coders.model.ForumMaster;

public interface ForumMaterDao {

	public void SaveOrUpdate(ForumMaster frm);
	
	public List<ForumMaster> list();//all view
	
	public void delete(int fid);
	
	public ForumMaster getFrm(int fid);//singl view
}
