package com.srini.dao;

import com.srini.dao.UsersDetailDao;
import com.srini.model.MUserRole;
import com.srini.model.MCart;
import com.srini.model.MUsersDetail;
import com.srini.model.MUsers;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UsersDetailDaoImpl implements UsersDetailDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addUser(MUsersDetail usersDetail) {
		Session session = sessionFactory.getCurrentSession();

		usersDetail.getBillingAddress().setUsersDetail(usersDetail);
		usersDetail.getShippingAddress().setUsersDetail(usersDetail);

		session.saveOrUpdate(usersDetail);
		session.saveOrUpdate(usersDetail.getBillingAddress());
		session.saveOrUpdate(usersDetail.getShippingAddress());

		MUsers newUser = new MUsers();
		newUser.setUsername(usersDetail.getUsername());
		newUser.setPassword(usersDetail.getPassword());
		newUser.setEnabled(true);
		newUser.setUserId(usersDetail.getUserId());

		MUserRole newUserRole = new MUserRole();
		newUserRole.setUsername(usersDetail.getUsername());
		newUserRole.setRole("ROLE_USER");
		session.saveOrUpdate(newUser);
		session.saveOrUpdate(newUserRole);

		MCart newCart = new MCart();
		newCart.setUsersDetail(usersDetail);
		usersDetail.setCart(newCart);
		session.saveOrUpdate(usersDetail);
		session.saveOrUpdate(newCart);

		session.flush();
	}

	public MUsersDetail getUserById(int userId) {
		Session session = sessionFactory.getCurrentSession();
		return (MUsersDetail) session.get(MUsersDetail.class, userId);
	}

	public List<MUsersDetail> getAllUsers() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MUsersDetail");
		List<MUsersDetail> usersDetail = query.list();

		return usersDetail;
	}

	public MUsersDetail getUserByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MUsersDetail where username = ?");
		query.setString(0, username);

		return (MUsersDetail) query.uniqueResult();
	}
}
