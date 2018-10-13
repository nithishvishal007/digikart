package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.SupplierDAO;
import com.niit.dao.UserDAO;
import com.niit.model.User;

public class UserDAOTest {
	static UserDAO userDAO;
	@BeforeClass
	public static void Initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		userDAO=(UserDAO)context.getBean("userDAO");
	}
	@Test
	
	public void registerUserTest()
	{
		User user=new User();
		user.setUsername("abi");
		user.setCustomername("Za");
		user.setEmailId("zabe@gmail.com");
		user.setEnabled("no");
		user.setMobileno("9097798472");
		user.setPassword("zabeer1996");
		user.setRole("customer");
		assertTrue("Problem in registering the user",userDAO.registerUser(user));
	}
	@Test
	@Ignore
	public void modifyUserTest()
	{
		User user=userDAO.getUser("Abdul");
		user.setMobileno("9487393622");
		assertTrue("problem in updating the user",userDAO.modifyUser(user));
	}
    @Test
    @Ignore
    public void getUser()
    {
    	assertNotNull("object should be null",userDAO.getUser("Abdul"));
    	User user=userDAO.getUser("Abdul");
    	System.out.println("Username: "+user.getUsername());
    	System.out.println("Password: "+user.getPassword());
    	System.out.println("Customer Name: "+user.getCustomername());
    	System.out.println("Email Id:"+user.getEmailId());
    	System.out.println("Mobile Number: "+user.getMobileno());
    	
    }
}
