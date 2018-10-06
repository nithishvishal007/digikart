package com.niit.imp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.UserDAO;
import com.niit.model.User;
@Repository("userDAO")
@EnableTransactionManagement
public class UserDAOImp implements UserDAO{
@Autowired
private SessionFactory sessionFactory;
public UserDAOImp(SessionFactory sessionFactory)
{
this.sessionFactory=sessionFactory;	
}
public boolean registerUser(User user)
{
try
{
sessionFactory.getCurrentSession().save(user);
return true;
}
catch(Exception e)
{
return false;	
}
}
public boolean modifyUser(User user)
{
try
{
sessionFactory.getCurrentSession().update(user);
return true;
}
catch(Exception e)
{
return false;	
} 
}
public User getUser(String username)
{
Session session=sessionFactory.openSession();
User user=(User)session.get(User.class,username);
session.close();
return user;
}
}
