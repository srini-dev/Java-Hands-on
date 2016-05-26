package com.srini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.srini.DAO.*;
import com.srini.model.*;
import com.srini.services.ProServiceImpl;
import com.srini.services.ProServices;



import java.util.*;

import javax.websocket.Session;

@Controller
public class ViewController {

	@Autowired
	private ProductData pData;
	@Autowired
	private ProServiceImpl pServ;
	String nam="";
	ProductData lst=null;
	
	
	
	
	@RequestMapping("/register")
	public String getRegi()
	{
		
		return "Register";
	}
	@RequestMapping("/login")
	public String getLog()
	{
		return "Login";
	}
	@RequestMapping("/imgA")
	public String getImageData()
	{
		return "ProData";
	}
	@RequestMapping("/product")
	public ModelAndView Products(@RequestParam(value="name", required=false,defaultValue="") String name)
	{
		ModelAndView prod=null;
		nam=name;
//		System.out.println("1VVVVVVVVVVVVVVV "+nam);
		prod=new ModelAndView("AllProducts");
		
		return prod;
	}
	@RequestMapping("/del")
	public ModelAndView getDelProd(@RequestParam(value="nnn", required=false,defaultValue="") String nnn)
	{
		ModelAndView mv=new ModelAndView("AllProducts");
		String pid=nnn;
		String fl=pServ.deleteProduct(pid);
		System.out.println("Deletes..............................");
		return mv;
	}
	@RequestMapping("/getEdit")
	public ModelAndView popEditPage(@RequestParam(value="nnn", required=false,defaultValue="") String nnn,@ModelAttribute("prod") Products prod,BindingResult result)
	{
		ModelAndView mv=new ModelAndView("EditProducts");
		System.out.println("UMMMMMMMMMMMMMMMMM "+nnn);
		String vpid=nnn;
		Products op=pServ.getProduct(nnn);
		mv.addObject("pd" ,op);
		return mv;
	}
	@RequestMapping("/edt")
	public ModelAndView updatDetProd(@RequestParam String pid, @ModelAttribute("prod") Products prod,BindingResult result)
	{
		ModelAndView mv=new ModelAndView("EditProducts");
		Products pro=null;
		String fl=pServ.updateProduct(prod);
		String msg="Data Updated Succefully";
		mv.addObject("msg", msg);
		
		return mv;
	}
	@RequestMapping("/addPro")
	public ModelAndView addProd(@RequestParam(value="nnn", required=false,defaultValue="") String nnn,@ModelAttribute("Product") Products Product)
	{
		ModelAndView mv=new ModelAndView("AllProducts");
		String pid=nnn;
		Products pro=null;
		String fl=pServ.updateProduct(Product);
		System.out.println("Updates.............................."+fl);
		return mv;
	}
	

	@RequestMapping("/GsonCon")
	public @ResponseBody String listUsers() {
		lst=new ProductData();
		String Prods="";
		List <Products> one_pro=new ArrayList<Products>();
		Products pro=null;
		if("allpro".equals(nam))
	    {
			Gson gson=null;
			List<Products> listPro =pData.proList();
			gson=new Gson();
			Prods=gson.toJson(listPro);
	    }
		else 
	    {
			Gson gson=null;
			Products op=pServ.getProduct(nam);
			List<Products> listPro = new ArrayList<Products>();
			listPro.add(op);
			gson=new Gson();
			Prods=gson.toJson(one_pro);
	    }
	 
	    return Prods;
	}
}
