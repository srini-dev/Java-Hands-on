package com.srini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.srini.model.*;
import com.srini.services.*;
import com.google.gson.Gson;
import com.srini.DAO.*;
import com.srini.model.*;




import java.util.*;



@Controller
public class ViewController {

	
	@Autowired
	private ProductData pData;
	@Autowired
	private ProServiceImpl pServ;
	String nam="";
	ProductData lst=null;
	
	String message = "Welcome ! ";
	String setName = ""; 
	public static String stat="off";	
	
	
	@RequestMapping("/register")
	public String getRegi()
	{
		
		return "Register";
	}
	@RequestMapping("/cat1")
	public String getCats(@RequestParam(value="name", required=false,defaultValue="") String name)
	{
		return "GridCat";
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
	

	
	@RequestMapping(value = { "/", "/welcome**" }, method = RequestMethod.GET)
	public ModelAndView defaultPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "This is default page!");
		model.setViewName("index");
		return model;

	}

	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage(@RequestParam(value="name", required=false,defaultValue="") String name) {
		nam=name;
		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Login Form - Database Authentication");
		model.addObject("message", "allpro");
		model.setViewName("AllProducts");

		return model;

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid username and password!");
			model.setViewName("index");
		}

		else if (logout != null) {
			model.addObject("msg", "");
			
			model.setViewName("index");
		}
		else
		model.setViewName("Login");

		return model;

	}
	
	//for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();
		
		//check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);
		
			model.addObject("username", userDetail.getUsername());
			
		}
		
		model.setViewName("403");
		return model;

	}
	
	
	
}
