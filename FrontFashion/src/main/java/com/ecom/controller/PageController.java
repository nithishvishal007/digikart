package com.ecom.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

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
	public String getHeader() {
		return "home";
	}

	
}
