package com.ecomm.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.OrderDetail;
@Repository("orderDetailDAO")

public class OrderDetailDAOImpl implements OrderDetailDAO 
{
	@Autowired
   	SessionFactory sessionFactory;

	@Transactional
	@Override
	public boolean ConfirmOrderDetail(OrderDetail orderDetail)
	{
		try
		{
			sessionFactory.getCurrentSession().save(orderDetail);
			return true;
		}
		catch(Exception e)
		{
			return false;	
		}
		
		
	}

}
