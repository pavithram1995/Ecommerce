package com.ecomm.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.Category;

public class CartItemDAOTest
{
	
static CartItemDAO cartDAO;
@Autowired
CategoryDAO categoryDAO;
	
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		cartDAO=(CartItemDAO)context.getBean("cartDAO");
	}

	@Test
	public void addCartTest()
	{
		CartItem cartItem=new CartItem();
		cartItem.setProductId(2);
		cartItem.setCartId(2);
		cartItem.setQuantity(5);
		cartItem.setUsername("user1");
		cartItem.setPaymentStatus("NP");
		cartItem.setSubtotal(499);
		cartItem.setProductName("motivational");
		assertTrue("Problem in Cart Insertion",cartDAO.addCart(cartItem));
	}
	@Ignore
	@Test
	public void getCartTest()
	{
		assertNotNull("Problem in get Category",cartDAO.getCartItem(2));
	}
	
	
	@Test
	public void deleteCartTest()
	{
		CartItem cartItem=cartDAO.getCartItem(192);
		assertTrue("Problem in Deletion:",cartDAO.deleteCartItem(cartItem));
	}
    
	@Ignore
	@Test
	public void updateCartTest()
	{
		CartItem cartItem=cartDAO.getCartItem(111);
		cartItem.setQuantity(2);
		assertTrue("Problem in Updation",cartDAO.updateCartItem(cartItem));
	}

}
