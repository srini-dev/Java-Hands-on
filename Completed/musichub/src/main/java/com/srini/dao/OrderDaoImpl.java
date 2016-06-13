package com.srini.dao;

import com.srini.dao.OrderDao;
import com.srini.model.MUserOrder;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addOrder(MUserOrder userOrder) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(userOrder);
		session.flush();
	}
}
