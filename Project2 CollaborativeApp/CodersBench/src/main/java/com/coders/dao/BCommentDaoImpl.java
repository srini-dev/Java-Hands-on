package com.coders.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coders.model.BComment;
import com.coders.model.BlogMaster;

public class BCommentDaoImpl implements BCommentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public BCommentDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public void SaveOrUpdate(BComment cmt) {
	
		this.sessionFactory.getCurrentSession().saveOrUpdate(cmt);
	}
	@Transactional
	public List<BComment> getCmts(int id) {
	
		String hql = "from BComment where bid="+id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<BComment> listCmt = (List<BComment>) query.list();
		
		if (listCmt != null && !listCmt.isEmpty()) {
			return listCmt;
		}
		
		return null;
	
	}
	@Transactional
	public List<BComment> getAll() {
	
		@SuppressWarnings("unchecked")
		List<BComment> listCmts = (List<BComment>) sessionFactory.getCurrentSession()
				.createCriteria(BComment.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listCmts;
	
	}

}
