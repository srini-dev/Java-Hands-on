package com.srini.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.srini.model.Products;







public class ProductData implements ProductList{

	List <Products>lst=new ArrayList<Products>();
	Products prod;
	@Autowired
	private SessionFactory sessionFactory;
	
	public ProductData() 
	{	System.out.println("In ProdData constructor");}
	
	
	
	public void setsessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		System.out.println("In sett Session Factory");
	}

	public Session getCurrentSession() {
		System.out.println("In getSessionFactory");
		return sessionFactory.getCurrentSession();
	}

	public int addProduct(Products pro) {
		Session session = sessionFactory.openSession();
	    Transaction tx = (Transaction) session.beginTransaction();
		System.out.println("After current");
		session.save(pro);
		 tx.commit();
		 Serializable id = session.getIdentifier(pro);
		 session.close();
		 return (Integer)id;
		
	}

	//Working fine
	public List<Products> proList() {
		
		List<Products> lst;
		System.out.println("KKKKKKKKKKKKKK Begin");
		//return getCurrentSession().createQuery("from Products").list();
		Session ses=sessionFactory.openSession();
		System.out.println("KKKKKKKKKKKK"+ses.isOpen());
		Query q=ses.createQuery("from Products");
		lst=q.list();
		return lst;
		
	} 
	public Products getProduct(String pid)
	{
		Session ses=sessionFactory.openSession();
		prod = (Products) ses.get(Products.class, pid);
		return prod;
	}
	public String delProduct(String pid)
	{
		 	Session session = sessionFactory.openSession();
		    Transaction tx = session.beginTransaction();
		    Products p = (Products) session.load(Products.class, pid);
		    session.delete(p);
		    tx.commit();
		    Serializable ids = session.getIdentifier(p);
		    session.close();
		    return (String) ids;
		
	}
	public String editProduct(Products pro)
	{
		Session session = sessionFactory.openSession();
	    Transaction tx = (Transaction) session.beginTransaction();
	    session.saveOrUpdate(pro);
	    tx.commit();
	    Serializable id = session.getIdentifier(pro);
	    session.close();
	    return (String) id;
	}
	


	
	

}
