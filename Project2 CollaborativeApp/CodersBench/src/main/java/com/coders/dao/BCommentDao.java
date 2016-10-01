package com.coders.dao;

import java.util.List;

import com.coders.model.BComment;



public interface BCommentDao {

	public void SaveOrUpdate(BComment cmt);
	public List<BComment> getCmts(int id);
	public List<BComment> getAll();
}
