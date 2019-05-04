package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.User;
@Transactional
@EnableTransactionManagement
@Repository("userDAO")
public class UserDAOImpl implements UserDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public boolean addUser(User user)
	{
		try
		{
		sessionFactory.getCurrentSession().save(user);
		System.out.println("User Added");
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception Arised:"+e);
		return false;
		}
	}
	
	@Override
	public boolean deleteUser(User user) 
	{
		try
		{
			sessionFactory.getCurrentSession().delete(user);
			System.out.println("User Deleted");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}

	}

	@Override
	public boolean updateUser(User user)
	{
		try
		{
			sessionFactory.getCurrentSession().update(user);
			System.out.println("User Updated");
			return true;
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised:"+e);
			return false;
		}
	}
	
	@Override
	public User getUser(int userId) 
	{
		Session session=sessionFactory.openSession();
		User user=(User)session.get(User.class,userId);
		session.close();
		return user;
	
	}
	
	@Override
	public List<User> getUser()
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from User");
		List<User> listUser=(List<User>)query.list();
		return listUser;
	}
	
	@Transactional
	public boolean isValidUser(String username, String password)
	{
		System.out.println("dao impl");
		String hql ="from User where username= '" + username + "' and " + " password ='" + password + "'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		@SuppressWarnings("unchecked")
		List<User> list = (List<User>) query.list();
		if(list != null && !list.isEmpty())
		{
		
			return true;
		}
		return false;

	}
	
	@Transactional
	public boolean save(User user)
	{
	try {
		 Session session = sessionFactory.getCurrentSession();
		
		user.setRole("ROLE_USER");
		user.setEnabled(true);
		
		
//		    CartItem newCart = new CartItem();
//	        newCart.setUser(user);
//	        user.setCartItem(newCart);
//	        session.saveOrUpdate(user);
//	        session.saveOrUpdate(newCart);

	        session.flush();
		
		return true;

	}
	catch(Exception e)
	{
		
		e.printStackTrace();
		return false;
	}

   }
	@Transactional
	@Override
	public User get(String username) 
	{
		String hql = "from User where username= "+" '" +username+ "'";
		Query query =sessionFactory.getCurrentSession().createQuery(hql);
		List<User> list = query.list();
		if(list == null || list.isEmpty())
		{
			return null;
		}
		else
		{
			return list.get(0);
		}
	}

	
}
