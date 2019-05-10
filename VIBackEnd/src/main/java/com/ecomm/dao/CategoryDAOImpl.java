package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Category;

@Repository("categoryDAO")//@Repository is an annotation that marks the specific class as a Data Access Object
public class CategoryDAOImpl implements CategoryDAO
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional//transaction propagation are handled automatically
	@Override
	public boolean addCategory(Category category)
	{
		try
		{
		sessionFactory.getCurrentSession().save(category);
	    System.out.println("Data saved");
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
	public boolean deleteCategory(Category category)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(category);
	    System.out.println("Data deleted");
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
	public boolean updateCategory(Category category)
	{
		try
		{
		sessionFactory.getCurrentSession().update(category);
	    System.out.println("Data updated");
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
	public Category getCategory(int categoryid)
	{
			Session session=sessionFactory.openSession();
			Category category=session.get(Category.class,categoryid);
			session.close();
			return category;
		
	}

	@Transactional
	@Override
	public List<Category> getCategories() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listCategories=(List<Category>)query.list();
		return listCategories;
	}
	
}
