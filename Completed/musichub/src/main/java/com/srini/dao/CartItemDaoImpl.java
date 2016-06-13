package com.srini.dao;

import com.srini.dao.CartItemDao;
import com.srini.model.MCart;
import com.srini.model.MCartItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class CartItemDaoImpl implements CartItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCartItem(MCartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(cartItem);
		session.flush();
	}

	public void removeCartItem(MCartItem cartItem) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(cartItem);
		session.flush();
	}

	public void removeAllCartItems(MCart cart) {
		List<MCartItem> cartItems = cart.getCartItems();

		for (MCartItem item : cartItems) {
			removeCartItem(item);
		}
	}

	public MCartItem getCartItemByItemId(int itemId) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MCartItem where itemId = ?");
		query.setInteger(0, itemId);
		session.flush();

		return (MCartItem) query.uniqueResult();
	}
}
