package com.niit.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

@Repository("productDAO")
@Transactional
public class ProductDAOImp implements ProductDAO{
@Autowired
    private SessionFactory sessionFactory;
    public ProductDAOImp(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
    
	public boolean addProduct(Product product) {
		// TODO Auto-generated method stub
    	try
    	{
    		sessionFactory.getCurrentSession().save(product);
    		return true;
    	}
    	catch(Exception e)
    	{
    		System.out.println("e" +e);
		return false;
    	}
	}
    
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		System.out.println(product.getProductname());
		try
		{
			
			sessionFactory.getCurrentSession().saveOrUpdate(product);
			System.out.println(product.getProductid()+" "+product.getQuantity()+ " is updated ");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("e" +e);
    	return false;
		}
	}
    
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listProduct=query.list();
		session.close();
		return listProduct;
	}

	public Product getProductById(int productid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Product product=(Product)session.get(Product.class,productid);
//		System.out.println(product);
		session.close();
		return product;
	}

	public boolean removeProduct(Product productid) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().remove(productid);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("e" +e);
			return false;
		}
	}

}
