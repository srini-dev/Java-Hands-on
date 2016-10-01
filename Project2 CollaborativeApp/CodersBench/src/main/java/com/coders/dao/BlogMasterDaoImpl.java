package com.coders.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coders.model.BlogMaster;



public class BlogMasterDaoImpl implements BlogMasterDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public BlogMasterDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void SaveOrUpdate(BlogMaster blog) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(blog);
		
	}
	@Transactional
	public List<BlogMaster> list() {
		@SuppressWarnings("unchecked")
		List<BlogMaster> listBlog = (List<BlogMaster>) sessionFactory.getCurrentSession()
				.createCriteria(BlogMaster.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listBlog;
	}

	@Transactional
	public void delete(int id) {
		BlogMaster BlogMasterToDelete = new BlogMaster();
		BlogMasterToDelete.setBid(id);
		sessionFactory.getCurrentSession().delete(BlogMasterToDelete);
		
	}
	@Transactional
	public BlogMaster getBlog(int id) {
		String hql = "from blogmaster where bbid=" + id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<BlogMaster> listBlog = (List<BlogMaster>) query.list();
		
		if (listBlog != null && !listBlog.isEmpty()) {
			return listBlog.get(0);
		}
		
		return null;
	}
	
}
