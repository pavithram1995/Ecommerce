package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.model.CartItem;

public class CartItemDAOImpl implements CartItemDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	
	public boolean addCart(CartItem cartItem)
	{
		try
		{
		sessionFactory.getCurrentSession().save(cartItem);
	    System.out.println("Cart added");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
    
	@Override
	public CartItem getCartItem(int cartItemId)
	{
		try
			{
			Session session=sessionFactory.openSession();
			CartItem cartItem=(CartItem)session.get(CartItem.class,cartItemId);
			return cartItem;
			}
			
			catch(Exception e){
				return null;
			}
	}
	@Transactional
	@Override
	public boolean deleteCartItem(CartItem cartItem)
	{
		try
		{
			sessionFactory.getCurrentSession().delete(cartItem);
			System.out.println("Cart Deleted");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	@Override
	public boolean updateCartItem(CartItem cartItem) 
	{
		try
		{
			sessionFactory.getCurrentSession().update(cartItem);
			System.out.println("Cart Updated");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	@Transactional
	@Override
	public List<CartItem> getCartItems(String username)
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query = session.createQuery("from CartItem where Username=:username and PaymentStatus='NP'");
			query.setParameter("username",username);
			List<CartItem> listCartItem=(List<CartItem>)query.list();
			return listCartItem;
		}
		catch(Exception e){
			return null;
		}
	
	}

	@Override
	public List<CartItem> paidCartItems(String username) 
	{
		try
		{
			Session session=sessionFactory.openSession();
			Query query = session.createQuery("from CartItem where Username=:username and PaymentStatus='P'");
			query.setParameter("username",username);
			List<CartItem> listCartItem=(List<CartItem>)query.list();
			return listCartItem;
		}
		catch(Exception e){
			return null;
		}
	}

}
