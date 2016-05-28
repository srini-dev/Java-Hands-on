package com.srini.DAO;
import java.util.*;

import com.srini.model.Products;
public interface ProductList {

	public List<Products> proList();
	public Products getProduct(String pid);
	public String delProduct(String pid);
	public String editProduct(Products pro);
	public int addProduct(Products pro);
	
	

}
