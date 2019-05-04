package com.ecomm.test;

import com.ecomm.SampleTesting.Customer;
import com.ecomm.model.CustomerDAO;

public class CustomerDAOTest 
{
	static CustomerDAO customerDAO;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		customerDAO=(customerDAO)context.getBean("customerDAO");
		
	}
	@Test
	public void addCustomerTest()
	{
		Customer customer=new Customer();
		customer.setstudId(1001);
		customer.setstudName("pavi");
		customer.setstudAddr("Tamil Nadu");
		
		assertTrue("Problem in customer insertion:",customerDAO.addCustomer(customer));
	}
	@Ignore
	@Test
	public void deleteCustomerTest()
	{
		Customer customer=customerDAO.getCustomer(1);
		
		assertTrue("Problem in customer insertion:",customerDAO.deleteCustomer(customer));
	}
}
