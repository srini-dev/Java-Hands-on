package com.coders;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView getLanding()
	{
		ModelAndView mv=new ModelAndView("index");
		return mv;
	}

	@RequestMapping("index")
	public String getBack1()
	{
		return "index";
	}
	@RequestMapping("/signin")
	public ModelAndView getLogin()
	{
		ModelAndView mv=new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/register")
	public ModelAndView getSignUp()
	{
		ModelAndView mv=new ModelAndView("register");
		return mv;
	}

	@RequestMapping("/menu")
	public ModelAndView getMenu()
	{
		ModelAndView mv=new ModelAndView("menu");
		return mv;
	}
	@RequestMapping("/openchat")
	public ModelAndView getChat()
	{
		ModelAndView mv=new ModelAndView("chat_app");
		return mv;
	}
}
