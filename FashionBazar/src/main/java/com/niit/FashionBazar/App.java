package com.niit.FashionBazar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.configuration.DBConfig;
import com.niit.dao.UserDAO;
import com.niit.model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
         ApplicationContext context=new AnnotationConfigApplicationContext(DBConfig.class);
         UserDAO udao=(UserDAO)context.getBean("userDAO");
         
         User u=new User();
         u.setCustomername("vishnu");
         u.setEmailId("v@gmail.com");
         u.setMobileno("8060654");
         u.setPassword("vishnu");
         u.setRole("admin");
         u.setUsername("v");
         udao.registerUser(u);
         System.out.println("saved");
    }
}
