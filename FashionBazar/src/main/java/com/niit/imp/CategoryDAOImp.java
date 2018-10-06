package com.niit.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.Product;
@Repository(value="categoryDAO")
@Transactional
public class CategoryDAOImp implements CategoryDAO {

	@Autowired
    private SessionFactory sessionFactory;
    public CategoryDAOImp(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
	public boolean addCategory(Category category) {
		try
    	{
    		sessionFactory.getCurrentSession().save(category);
    		return true;
    	}
    	catch(Exception e)
    	{
    		System.out.println("e" +e);
		
		return false;
    	}
	}

	public boolean updateCategory(Category category) {
		try
    	{
    		sessionFactory.getCurrentSession().update(category);
    		return true;
    	}
    	catch(Exception e)
    	{
    		System.out.println("e" +e);
		// TODO Auto-generated method stub
		return false;
    	}
	}

	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategory=query.list();
		session.close();
		return listCategory;
	}

	public Category getCategoryById(int categoryid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Category category=(Category)session.get(Category.class,categoryid);
		session.close();
		return category;
	}

	public boolean removeCategory(Category category) {
		// TODO Auto-generated method stub
		try
    	{
    		sessionFactory.getCurrentSession().remove(category);
    		return true;
    	}
    	catch(Exception e)
    	{
    		System.out.println("e" +e);
		return false;
    	}
	}

}
