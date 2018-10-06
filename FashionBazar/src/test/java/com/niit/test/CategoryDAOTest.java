package com.niit.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.dao.CategoryDAO;
import com.niit.model.Category;
import com.niit.model.Product;

public class CategoryDAOTest {

	 static CategoryDAO categoryDAO;
	 @BeforeClass
	 public static void Initialize()
	 {
	 	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	 	context.scan("com.niit");
	 	context.refresh();
	 	categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	 }
	 @Test
	 public void addCategoryTest()
	 {

	     Category category=new Category();
	     category.setCategoryName("Samsung");
	     category.setCategoryDesc("All mobiles with 4G and VOLTE of samsung");
	     assertTrue("Problem in adding the product",categoryDAO.addCategory(category));
	    
	      //Category category=new Category();
		  category.setCategoryName("Lenovo");
		  category.setCategoryDesc("All mobiles with 4G and VOLTE of lenovo");
		  assertTrue("Problem in adding the product",categoryDAO.addCategory(category));

	 }
	@Ignore
	   @Test
		public void updateCategoryTest()
		{
			Category category=categoryDAO.getCategoryById(48);
			category.setCategoryDesc("all the xiomi mobile with smart features");
			assertTrue("problem in updating the category", categoryDAO.updateCategory(category));
		}

		@Test
		@Ignore
		public void getCategoryByIdTest()
		{
			//Category category=categoryDAO.getCategoryById(2);
			assertNotNull("displaying the respected category name by its category id", categoryDAO.getCategoryById(49));
			Category category=categoryDAO.getCategoryById(49);
			System.out.println("Product Id:"+category.getCategoryid());
			System.out.println("Product Name:"+category.getCategoryName());
		}
		@Test
		@Ignore
		public void listCategoryTest()
		{
			List<Category> listCategory=categoryDAO.listCategory();
			assertNotNull("Problem in Listing Categories",listCategory);
			
			for(Category category:listCategory)
			{
				System.out.print(category.getCategoryid()+":::");
				System.out.print(category.getCategoryName()+":::");
				System.out.println(category.getCategoryDesc());
			}
		}
	
@Ignore
@Test
		public void removeCategoryTest()
		{
			Category category=categoryDAO.getCategoryById(48);
			assertTrue("the removed category is as follows", categoryDAO.removeCategory(category));
		}

}
