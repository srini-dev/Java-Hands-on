package com.srini.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.srini.model.MItem;
import com.srini.service.ItemService;
import java.util.List;
/*
 * This controller is used to handle login, home and about us functionality
 */
@Controller
public class LoginInfoController{
	
	 @Autowired
	 private ItemService itemService;
	
	/*
	 * home method is used to land a user on home page
	 */
	 @RequestMapping("/")
	    public String getItemsHome(Model model) {
	        List<MItem> item = itemService.getItemList();
	        model.addAttribute("items", item);

	        return "index";
	    }
	 @RequestMapping("/home")
	    public String getItemsHome2(Model model) {
	        List<MItem> item = itemService.getItemList();
	        model.addAttribute("items", item);

	        return "home";
	    }
    /*
     * login method is used to handle user login related functionality
     */
    @RequestMapping("/login")
    public String login(@RequestParam(value="error", required = false) String error, @RequestParam(value="logout",
            required = false) String logout, Model model) {
        if (error!=null) {
            model.addAttribute("error", "Invalid username and password");
        }

        if(logout!=null) {
            model.addAttribute("msg", "You have been logged out successfully.");
            return "/";
        }
       
        

        return "login";
    }
    /*
     * about method is used to land a user on about us page.
     */
    @RequestMapping("/about")
    public String about() {
        return "aboutUs";
    }    
   
}
