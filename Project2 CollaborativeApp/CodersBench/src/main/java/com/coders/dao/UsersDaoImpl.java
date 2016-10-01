package com.coders.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.coders.model.BlogMaster;
import com.coders.model.Users;

public class UsersDaoImpl implements UsersDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public UsersDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	@Transactional
	public List<Users> getAllUser() {
		@SuppressWarnings("unchecked")
		List<Users> listUsers = (List<Users>) sessionFactory.getCurrentSession().createCriteria(Users.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		        return listUsers;
	}
	@Transactional
	public Users getUsr(String uid, String pwd) {
		System.out.println("asfaaaadada "+uid);
		String hql = "from Users where uid= '" + uid + "' and " + " pwd ='" + pwd+"'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		
		@SuppressWarnings("unchecked")
		List<Users> listUsrs = (List<Users>) query.list();
		
		if (listUsrs != null && !listUsrs.isEmpty()) {
			return listUsrs.get(0);
		}
		
		return null;
	}

	@Transactional
	public void SaveOrUpdate(Users usr) {
		this.sessionFactory.getCurrentSession().saveOrUpdate(usr);
		
	}

	@Transactional
	public void delete(int id) {
		Users usrToDelete = new Users();
		usrToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(usrToDelete);
		
	}

}
