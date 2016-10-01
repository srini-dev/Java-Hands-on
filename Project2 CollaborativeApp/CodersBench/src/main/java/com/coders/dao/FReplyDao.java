package com.coders.dao;

import java.util.List;

import com.coders.model.FReply;

public interface FReplyDao {

	public void SaveOrUpdate(FReply rpl);
	public List<FReply> getRpls(int id);
}
