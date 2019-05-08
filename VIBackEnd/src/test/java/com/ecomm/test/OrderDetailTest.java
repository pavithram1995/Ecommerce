package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.model.OrderDetail;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class OrderDetailTest
{
	static OrderDetailDAO orderDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		orderDAO=(OrderDetailDAO)context.getBean("orderDAO");
	}
	@Ignore
	@Test
	public void addOrder()
	{
		OrderDetail order=new OrderDetail();
		order.setTranType("CC");
		order.setTotalAmount(100);
		order.setOrderDate(String.format("%tc",new Date()));
		order.setShippingAddr("chennai");
		order.setUsername("user");
		assertTrue("Problem in Category Insertion",orderDAO.ConfirmOrderDetail(order));
	}
}
