package com.srini.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.srini.DAO.ProductData;
import com.srini.model.Products;


@Service
@Transactional
public class ProServiceImpl implements ProServices{

	@Autowired
	private ProductData pData;
	public int adProduct(Products pro) {
		return pData.addProduct(pro);
	}

	public List getAllPro() {
		
		return pData.proList();
	}
	public Products getProduct(String pid)
	{
		return pData.getProduct(pid);
	}
	public String deleteProduct(String pid)
	{
		System.out.println("Del..............................");
		return pData.delProduct(pid);
	}
	
	public String updateProduct(Products pro)
	{
		return pData.editProduct(pro);
	}

	
	
}
