package com.ecomm.SampleTesting;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


@Transactional



public class TestMain implements MainInterface 
{
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public boolean addTest(ClassTest classTest) 
	{
		try
		{
			sessionFactory.getCurrentSession().save(classTest);
			return true;
			
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

}
