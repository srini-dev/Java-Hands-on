package com.srini.dao;

import com.srini.dao.CardDetailDao;
import com.srini.model.MCardDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CardDetailDaoImpl implements CardDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCardDetail(MCardDetail cardDetail) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cardDetail);

		session.flush();
	}

}
