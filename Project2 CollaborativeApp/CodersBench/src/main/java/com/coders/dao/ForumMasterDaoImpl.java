package com.coders.dao;


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coders.model.BlogMaster;
import com.coders.model.ForumMaster;

public class ForumMasterDaoImpl implements ForumMaterDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public ForumMasterDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}

	@Transactional
	public void SaveOrUpdate(ForumMaster frm) {
		
		this.sessionFactory.getCurrentSession().saveOrUpdate(frm);
	}
	@Transactional
	public List<ForumMaster> list() {
		
		@SuppressWarnings("unchecked")
		List<ForumMaster> listFrms = (List<ForumMaster>) sessionFactory.getCurrentSession()
				.createCriteria(ForumMaster.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listFrms;
	}
	@Transactional
	public void delete(int fid) {
		ForumMaster ForumMasterToDelete = new ForumMaster();
		ForumMasterToDelete.setFid(fid);
		sessionFactory.getCurrentSession().delete(ForumMasterToDelete);
		
	}
	@Transactional
	public ForumMaster getFrm(int fid) {
		String hql = "from ForumMaster where fid=" + fid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ForumMaster> listFrm = (List<ForumMaster>) query.list();
		
		if (listFrm != null && !listFrm.isEmpty()) {
			return listFrm.get(0);
		}
		
		return null;
	}
	@Transactional
	public int getlikes(int fid) {
		String hql = "from ForumMaster where fid=" + fid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<ForumMaster> listFrm = (List<ForumMaster>) query.list();
		
		if (listFrm != null && !listFrm.isEmpty()) {
			return listFrm.get(0).getFcmtct();
		}
		return 0;
	}
}
