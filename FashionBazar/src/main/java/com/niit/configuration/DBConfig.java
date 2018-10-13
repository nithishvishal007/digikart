package com.niit.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.Category;
import com.niit.model.OrderDetail;
import com.niit.model.Orders;
import com.niit.model.Product;
import com.niit.model.Supplier;
import com.niit.model.User;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.niit")
public class DBConfig {
       
		//private Object getH2DataSource;
	
		@Bean(name="dataSource")
		public DataSource getDataSource() {
		    DriverManagerDataSource dataSource = new DriverManagerDataSource();
		    dataSource.setDriverClassName("org.h2.Driver");
		    dataSource.setUrl("jdbc:h2:tcp://localhost/~/project1");
		  
		    dataSource.setUsername("sa");
		    dataSource.setPassword("");
		    return dataSource;
		}
	    @Autowired
		@Bean(name="sessionFactory")
		public SessionFactory getSessionFactory(){
			
	            Properties hibernateproperties = new Properties();
	            hibernateproperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
	            hibernateproperties.setProperty("hibernate.hbm2ddl.auto","update");
	            hibernateproperties.put("hibernate.show_sql", true);
	            LocalSessionFactoryBuilder localsessionFactorybuilder=new LocalSessionFactoryBuilder(getDataSource());
	            localsessionFactorybuilder.addProperties(hibernateproperties);
	            
	            localsessionFactorybuilder.addAnnotatedClass(Category.class);
	            localsessionFactorybuilder.addAnnotatedClass(Product.class);
	            localsessionFactorybuilder.addAnnotatedClass(Supplier.class);
	            localsessionFactorybuilder.addAnnotatedClass(User.class);
	            localsessionFactorybuilder.addAnnotatedClass(Cart.class);
	            localsessionFactorybuilder.addAnnotatedClass(OrderDetail.class);
	            localsessionFactorybuilder.addAnnotatedClass(CartItem.class);
	            localsessionFactorybuilder.addAnnotatedClass(Orders.class);
	            
	            

	            SessionFactory sessionFactory=localsessionFactorybuilder.buildSessionFactory();
	            
	            return sessionFactory;        
	       }
	    @Autowired
	    @Bean(name="transactionManager")
		public HibernateTransactionManager hibTransMan()
		{
	    	return new HibernateTransactionManager(getSessionFactory());
	    	
		}
	} 

