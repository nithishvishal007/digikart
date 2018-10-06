package com.niit.imp;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.dao.OrderDAO;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;

@Repository("orderDAO")
@Transactional
public class OrderDAOImp implements OrderDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean insertOrderDetail(OrderDetail orderDetail) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public void addOrder(Orders order) {
		// TODO Auto-generated method stub
		
	}

	

}
