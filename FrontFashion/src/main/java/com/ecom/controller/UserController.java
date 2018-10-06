package com.ecom.controller;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController 
{
	
	@RequestMapping("/login_success")
	public String loginProcess(HttpSession session,Model m)
	{
		String page=null;
		boolean loggedIn=true;
		
		System.out.println("Login Success :");
		
		SecurityContext securityContext=SecurityContextHolder.getContext();
		Authentication authentication=securityContext.getAuthentication();
		String username=authentication.getName();
		
		System.out.println(username);
		Collection<GrantedAuthority> roles=(Collection<GrantedAuthority>)authentication.getAuthorities();
		
		for(GrantedAuthority role:roles)
		{
			
			String roleName=role.getAuthority();
			session.setAttribute("loggedIn", loggedIn);
			session.setAttribute("username",username);
			session.setAttribute("role",roleName);
			
			if(roleName.equals("ROLE_USER"))
			{
				page="UserHome";
			}
			else
			{
				page="AdminHome";	
			}
		}
		
		return page;
	}
	@RequestMapping("/perform_login")
	public String loging(HttpServletRequest req, @RequestParam("username")String username,@RequestParam("password")String password)
	{
		System.out.println("processing login");
		username = req.getParameter("username");
		password = req.getParameter("password");
		return "";
	}
	
	@RequestMapping("/perform_logout")
	public String loggingOut(HttpSession session,Model m)
	{
		System.out.println("logging out");
		session.invalidate();
		m.addAttribute("errorInfo","Successfully Logged Out");
		return "Login";
	}
}
