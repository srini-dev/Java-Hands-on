package com.srini.services;

import java.util.List;


import com.srini.model.Products;



public interface ProServices {

	
	public List getAllPro();
	public Products getProduct(String pid);
	public String deleteProduct(String pid);
	public String updateProduct(Products pro);
	public int adProduct(Products pro);
}
