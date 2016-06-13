package com.srini.dao;

import com.srini.dao.ItemDao;
import com.srini.model.MItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory sessionFactory;

	public MItem getItemById(int id) {
		Session session = sessionFactory.getCurrentSession();
		MItem item = (MItem) session.get(MItem.class, id);
		session.flush();

		return item;
	}

	public List<MItem> getItemList() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from MItem");
		List<MItem> itemList = query.list();
		session.flush();

		return itemList;
	}

	public void addItem(MItem item) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
		session.flush();
	}

	public void editItem(MItem item) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
		session.flush();
	}

	public void deleteItem(MItem item) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(item);
		session.flush();
	}
}
