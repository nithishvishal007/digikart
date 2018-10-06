package com.niit.dao;

import java.util.List;

import javax.transaction.Transactional;


import com.niit.model.Category;



public interface CategoryDAO {
public boolean addCategory(Category category);
public boolean updateCategory(Category category);
public List<Category> listCategory();
public Category getCategoryById(int categoryid);
public boolean removeCategory(Category category);
}
