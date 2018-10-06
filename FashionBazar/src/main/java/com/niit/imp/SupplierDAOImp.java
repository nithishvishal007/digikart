package com.niit.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;
@Repository("supplierDAO")
@Transactional
public class SupplierDAOImp implements SupplierDAO {
	@Autowired
    private SessionFactory sessionFactory;
    public SupplierDAOImp(SessionFactory sessionFactory)
    {
    	this.sessionFactory=sessionFactory;
    }
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try
    	{
    		sessionFactory.getCurrentSession().persist(supplier);
    		return true;
    	}
    	catch(Exception e)
    	{
    		System.out.println("e" +e);
		
		return false;
    	}

	}

	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try
    	{
    		sessionFactory.getCurrentSession().update(supplier);
    		return true;
    	}
    	catch(Exception e)
    	{
    		System.out.println("e" +e);
		
		return false;
    	}
	}

	public List<Supplier> listSupplier() {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listSupplier=query.list();
		session.close();
		return listSupplier;
	}

	public Supplier getSupplierById(int supplierid) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Supplier supplier=(Supplier)session.get(Supplier.class,supplierid);
//		System.out.println(product);
		session.close();
		return supplier;
	}

	public boolean removeSupplier(Supplier supplierid) {
		// TODO Auto-generated method stub
		try
		{
			sessionFactory.getCurrentSession().remove(supplierid);
			return true;
			
		}
		catch(Exception e)
		{
			System.out.println("e" +e);
			return false;
		}
	}
	

}
