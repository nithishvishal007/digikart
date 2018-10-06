package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.ProductDAO;
import com.niit.model.Product;

public class ProductDAOTest {
    static ProductDAO productDAO;
@BeforeClass
public static void Initialize()
{
	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	context.scan("com.niit");
	context.refresh();
	productDAO=(ProductDAO)context.getBean("productDAO");
}
@Test

public void addProductTest()
{

    Product product=new Product();
    product.setProductname("Samsung J7");
    product.setProductDesc("All mobiles with 4G and VOLTE");
    product.setPrice(35000);
    product.setSupplierid(2);
    product.setCategoryid(1);
    //product.setProductid(1);
    product.setQuantity(2);
    assertTrue("Problem in adding the product",productDAO.addProduct(product));
    
    //Product product1=new Product();
    product.setProductname("Lenovo 400");
    product.setProductDesc("All mobiles with 4G and VOLTE of lenovo");
    product.setPrice(45000);
    product.setSupplierid(2);
    product.setCategoryid(2);
    //product1.setProductid(2);
    product.setQuantity(4);
    assertTrue("Problem in adding the product",productDAO.addProduct(product));
    
    
}
@Test
@Ignore
public void updateProductTest()
{
	Product product=productDAO.getProductById(34);
	product.setProductDesc("lenovo");
	assertTrue("problem is updating the product",productDAO.updateProduct(product));
}
@Test
@Ignore
public void removeProductTest()
{
	Product product=productDAO.getProductById(35);
	assertTrue("problem in deleting the product",productDAO.removeProduct(product));
}
@Test
@Ignore
public void getProductByIdTest()
{
	//Product product=productDAO.getProductById(20);
	assertNotNull("Object should be null", productDAO.getProductById(34));
	Product product=productDAO.getProductById(34);
	System.out.println("Product Id:"+product.getProductid());
	System.out.println("Product Name:"+product.getProductname());

}
@Test
@Ignore
public void listPrductTest()
{
	List<Product> products=productDAO.listProduct();
	assertNotNull("products are exist", products);
	for(Product product:products)
	{
		System.out.println("Product Id:"+product.getProductid());
		System.out.println("Product Name:"+product.getProductname());
	}
}
}
