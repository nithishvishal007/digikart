package com.niit.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.niit.dao.SupplierDAO;
import com.niit.model.Supplier;

public class SupplierDAOTest {
	
	static SupplierDAO supplierDAO;
	@BeforeClass
	public static void Initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		supplierDAO=(SupplierDAO)context.getBean("supplierDAO");
	}
	@Test
	public void addSupplierTest() {
	
		Supplier supplier= new Supplier();
		supplier.setSuppliername("poorviga");
		supplier.setAddress("jayanagar 3rd block");
		assertTrue("Problem in adding the supplier",supplierDAO.addSupplier(supplier));
	}
}
