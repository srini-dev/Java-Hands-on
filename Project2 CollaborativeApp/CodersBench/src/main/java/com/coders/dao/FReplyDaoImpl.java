package com.coders.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coders.model.BComment;
import com.coders.model.FReply;

public class FReplyDaoImpl implements FReplyDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public FReplyDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void SaveOrUpdate(FReply rpl) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(rpl);
	}
	
	@Transactional
	public List<FReply> getRpls(int id) {
		String hql = "from FReply where fid=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<FReply> listRpl = (List<FReply>) query.list();
		
		if (listRpl != null && !listRpl.isEmpty()) {
			return listRpl;
		}
		return null;
	}

}
