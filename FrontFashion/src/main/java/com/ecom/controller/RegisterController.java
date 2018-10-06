package com.ecom.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.dao.UserDAO;
import com.niit.model.Category;
import com.niit.model.Product;
import com.niit.model.User;



@Controller
public class RegisterController {
	
	@Autowired
	UserDAO userDAO;

boolean flag=true;
	
	@RequestMapping(value="/register")
	public String showManageRegister(Model m)
	{
		User user=new User();
		m.addAttribute("User",user);
		return "Register";
	}
	@ModelAttribute("user")
	public User u1()
	{
		return new User();
	}
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String RegisterUser(@ModelAttribute("user")User user,Model m)
	{
		user.setRole("ROLE_USER");
		user.setEnabled("yes");
		userDAO.registerUser(user);
		return "redirect:/Login";
	}
}
