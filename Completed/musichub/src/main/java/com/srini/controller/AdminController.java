package com.srini.controller;

import com.srini.model.MItem;
import com.srini.model.MUsersDetail;
import com.srini.service.ItemService;
import com.srini.service.UsersDetailService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;;

/*
 *Only for admin Role
 *This controller is used to add, edit and delete items.
*/

@Controller
@RequestMapping("/admin")
public class AdminController {

	private Path path;
	private List<String> categoryList;

	@Autowired
	private ItemService itemService;

	@Autowired
	private UsersDetailService usersDetailService;

	public List<String> addCategoryList() {
		categoryList = new ArrayList<String>();
		categoryList.add("Music Instrument");
		categoryList.add("Others");

		return categoryList;

	}

	@RequestMapping("/item/addItem")
	public String addItem(Model model) {
		addCategoryList();
		MItem item = new MItem();
		item.setItemStatus("active");

		model.addAttribute("item", item);
		model.addAttribute("categoryList", categoryList);

		return "addItem";
	}

	/*
	 * addItemPost method is used to add a item and it is calling to addItem
	 * method internally.
	 */
	@RequestMapping(value = "/item/addItem", method = RequestMethod.POST)
	public String addItemPost(@Valid @ModelAttribute("item") MItem item, BindingResult result,
			HttpServletRequest request, Model model) {

		addCategoryList();

		model.addAttribute("categoryList", categoryList);

		if (result.hasErrors()) {
			return "addItem";
		}

		itemService.addItem(item);

		MultipartFile itemImage = item.getItemImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + item.getItemId() + ".png");

		if (itemImage != null && !itemImage.isEmpty()) {
			try {
				itemImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("item image saving failed.", e);
			}
		}

		return "redirect:/admin/Instrumentsinventory";
	}

	/*
	 * editItem method is used to edit a item.
	 */
	@RequestMapping("/item/editItem/{id}")
	public String editItem(@PathVariable("id") int id, Model model) {
		addCategoryList();

		model.addAttribute("categoryList", categoryList);
		MItem item = itemService.getItemById(id);

		model.addAttribute("item", item);

		return "editItem";
	}

	/*
	 * editItemPost method is used to edit a item.and it is calling to editItem
	 * method internally
	 */
	@RequestMapping(value = "/item/editItem", method = RequestMethod.POST)
	public String editItemPost(@Valid @ModelAttribute("item") MItem item, BindingResult result,
			HttpServletRequest request, Model model) {
		addCategoryList();

		model.addAttribute("categoryList", categoryList);

		if (result.hasErrors()) {
			return "editItem";
		}

		MultipartFile itemImage = item.getItemImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + item.getItemId() + ".png");

		if (itemImage != null && !itemImage.isEmpty()) {
			try {
				itemImage.transferTo(new File(path.toString()));
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Item image saving failed.", e);
			}
		}

		itemService.editItem(item);

		return "redirect:/admin/Instrumentsinventory";
	}

	/*
	 * deleteItem method is used to delete a item.
	 */
	@RequestMapping("/item/deleteItem/{id}")
	public String deleteItem(@PathVariable int id, Model model, HttpServletRequest request) {
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		path = Paths.get(rootDirectory + "\\WEB-INF\\resources\\images\\" + id + ".png");

		if (Files.exists(path)) {
			try {
				Files.delete(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		MItem item = itemService.getItemById(id);
		itemService.deleteItem(item);

		return "redirect:/admin/Instrumentsinventory";
	}

	@RequestMapping("/Instrumentsinventory")
	public String itemInventory(Model model) {
		List<MItem> items = itemService.getItemList();
		model.addAttribute("items", items);

		return "Instrumentsinventory";
	}

	/*
	 * userManagement method is used to open user management page.
	 */
	@RequestMapping("/user")
	public String userManagement(Model model) {

		List<MUsersDetail> usersDetailList = usersDetailService.getAllUsers();
		model.addAttribute("usersDetailList", usersDetailList);

		return "userManagement";
	}

}
