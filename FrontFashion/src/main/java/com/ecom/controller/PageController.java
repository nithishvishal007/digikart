package com.ecom.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.CategoryDAO;
import com.niit.dao.ProductDAO;
import com.niit.model.Category;
import com.niit.model.Product;

@Controller
public class PageController {

	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/Login")
	public String showLoginPage() {
		return "Login";
	}

	@RequestMapping("/Register")
	public String showRegisterPage() {
		return "Register";
	}

	@RequestMapping("/contactus")
	public String showContactUsPage() {
		return "ContactUs";
	}

	@RequestMapping("/ProductDisplay")
	public String showproductdsipPage() {
		return "ProductDisplay";
	}
	@RequestMapping("/aboutus")
	public String showAboutUsPage() {
		return "AboutUs";
	}
	
	@RequestMapping(value= {"/","/home"})
	public String getHeader( Model m) {

		List<Product> productList=productDAO.listProduct();
		m.addAttribute("productList", productList);
		
		List<Category> categoryList=categoryDAO.listCategory();
		m.addAttribute("categoryList", this.getCategoryList(categoryList));

		return "home";
	}

	public LinkedHashMap<Integer,String> getCategoryList(List<Category> listCategory)
	{
		
		LinkedHashMap<Integer,String> categoryData=new LinkedHashMap<Integer,String>();
		
		int count=0;
		while(count<listCategory.size())
		{
			categoryData.put(listCategory.get(count).getCategoryid(),listCategory.get(count).getCategoryName());
			count++;
		}
		
		return categoryData;
	}
}
