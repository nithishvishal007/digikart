package com.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;

@Controller

public class CategoryController {

	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping(value="/category")
	public String showCategoryPage(Model m)
	{
		List<Category> listCategory=categoryDAO.listCategory();
		m.addAttribute("categoryList", listCategory);
		return "Category";
	}
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	public String addCategory(@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		
		Category category=new Category();
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.addCategory(category);
		
		List<Category> listCategory=categoryDAO.listCategory();
		m.addAttribute("categoryList", listCategory);
		
		return "Category";
	}
	
	@RequestMapping(value="/updateCategory",method=RequestMethod.POST)
	public String updateCategory(@RequestParam("categoryid")int categoryid,@RequestParam("categoryName")String categoryName,@RequestParam("categoryDesc")String categoryDesc,Model m)
	{
		
		Category category=categoryDAO.getCategoryById(categoryid);
		category.setCategoryName(categoryName);
		category.setCategoryDesc(categoryDesc);
		
		categoryDAO.updateCategory(category);
		
		List<Category> listCategory=categoryDAO.listCategory();
		m.addAttribute("categoryList", listCategory);
		
		return "Category";
	}
	
	@RequestMapping(value="/deleteCategory/{categoryid}")
	public String deleteCategory(@PathVariable("categoryid")int categoryid,Model m)
	{
		Category category=categoryDAO.getCategoryById(categoryid);
		categoryDAO.removeCategory(category);
		
		List<Category> listCategory=categoryDAO.listCategory();
		m.addAttribute("categoryList", listCategory);
		
		return "Category";
	}
	
	@RequestMapping(value="/editCategory/{categoryid}")
	public String editCategory(@PathVariable("categoryid")int categoryid,Model m)
	{
		Category category=categoryDAO.getCategoryById(categoryid);
		m.addAttribute("categoryData", category);
		return "UpdateCategory";
	}

}
