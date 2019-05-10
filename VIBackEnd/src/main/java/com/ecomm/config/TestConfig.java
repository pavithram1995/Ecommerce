package com.ecomm.config;

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

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.CartItemDAOImpl;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.CategoryDAOImpl;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.OrderDetailDAOImpl;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.ProductDAOImpl;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.dao.SupplierDAOImpl;
import com.ecomm.dao.UserDAO;
import com.ecomm.dao.UserDAOImpl;
import com.ecomm.model.CartItem;
import com.ecomm.model.Category;
import com.ecomm.model.OrderDetail;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;
import com.ecomm.model.User;


@Configuration
				/*@Configuration annotation on top 
				of any class to declare that this class provides 
				one or more @Bean methods and may be processed by the
 				Spring container to generate bean definitions and service
  				requests for those beans at runtime.*/
@ComponentScan("com.ecomm")
//@ComponentScan annotation is used with the @Configuration annotation to tell Spring the packages to scan for annotated components. 
@EnableTransactionManagement
//@Transactional on itself or its members, Spring creates a proxy that implements the same interface(s) as the class you're annotating
public class TestConfig 
{
	@Autowired
	/*@Autowired annotation can be used to autowire bean on the setter method, Autowiring feature of spring framework 
	enables you to inject the object dependency implicitly.*/
	@Bean (name="dataSource")
	/*
	 Spring @Bean Annotation is applied on a method to specify that it returns a bean to be managed by Spring context.
	  Spring Bean annotation is usually declared in Configuration classes methods. In this case, bean methods may reference other
	   @Bean methods in the same class by calling them directly.
	   JavaBean class in Java. JavaBeans are classes that encapsulate many objects into a single object (the bean). 
	    All properties in java bean must be private with public getters and setter methods.
	 */
	public DataSource getH2DataSource()//The DataSource(interface) object can be used to create a connection to the data source it represents.
	{
		System.out.println("Data Source Object Creating");
		DriverManagerDataSource dataSource = new DriverManagerDataSource();//Configuring the plain old JDBC DriverManager via bean properties, and returning a new Connection from every getConnection call.
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/ecomdb");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		System.out.println("Data Source Object Created");
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")

	public SessionFactory getSessionFactory() 
	//This object is a kind of factory object which can create multiple sessions.Each session will be used for connectivity with the database.
	// (Session)This particular component will basically used for doing all the CRUD operation on database.
	{
		System.out.println("Hibernate Properties Object Creating");
		Properties properties = new Properties();
		properties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		/*
		 Hibernate can work with different databases.Hibernate uses "dialect" 
		 configuration to know which database you are using so that it can switch to the database specific SQL generator code wherever/whenever necessary.
		 */
		properties.put("hibernate.hbm2ddl.auto","update");
		/*
		 	hibernate.hbm2ddl.auto Automatically validates or exports schema DDL to the database when the SessionFactory is created. 
		   With create-drop, the database schema will be dropped when the SessionFactory is closed explicitly.
		 */
		System.out.println("Hibernate Properties Object Created");
		System.out.println("Table Source Created");
		System.out.println("Session Factory Object Creating");
		LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getH2DataSource());
		sessionBuilder.addProperties(properties);
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(CartItem.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(OrderDetail.class);
		System.out.println("Session Factory Object Created");
		return sessionBuilder.buildSessionFactory();
	}	
	
	@Autowired
	@Bean(name="transactionManager")
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		System.out.println("Transaction Manager Object Creating");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		System.out.println("Transaction Manager Object Created");
		return transactionManager;
	}
	
	@Bean(name="categoryDAO")
	public CategoryDAO getCategoryDAO()
	{
		System.out.println("----Category DAO Implementation---");
		return new CategoryDAOImpl();
	}
	
	@Bean(name="supplierDAO")
	public SupplierDAO getSupplierDAO()
	{
		System.out.println("----Supplier DAO Implementation---");
		return new SupplierDAOImpl();
	}
	@Bean(name="productDAO")
	public ProductDAO getProductDAO()
	{
		System.out.println("----Product DAO Implementation---");
		return new ProductDAOImpl();
	}
	@Bean(name="cartDAO")
	public CartItemDAO getCartItemDAO()
	{
		System.out.println("----Cart DAO Implementation---");
		return new CartItemDAOImpl();
	}
	@Bean(name="userDAO")
	public UserDAO getUserDAO()
	{
		System.out.println("----User DAO Implementation---");
		return new UserDAOImpl();
	}
	@Bean(name="orderDAO")
	public OrderDetailDAO getuserDAO()
	{
		System.out.println("----order DAO Implementation---");
		return new OrderDetailDAOImpl();
	}
}