package com.niit.dao;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.niit.model.User;
@Repository("userDAO")
@Transactional
public interface UserDAO {
public boolean registerUser(User user);
public boolean modifyUser(User user);
public User getUser(String username);
}
