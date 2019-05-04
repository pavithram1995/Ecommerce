package com.ecomm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ecomm.model.Supplier;

@Repository("supplierDAO")

public class SupplierDAOImpl implements SupplierDAO
	{
	@Autowired
	SessionFactory sessionFactory;

		@Transactional
		@Override
		public boolean addSupplier(Supplier supplier)
		{
			try
			{
			sessionFactory.getCurrentSession().save(supplier);
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
		public boolean deleteSupplier(Supplier supplier)
		{
			try
			{
			sessionFactory.getCurrentSession().delete(supplier);
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
		public boolean updateSupplier(Supplier supplier)
		{
			try
			{
			sessionFactory.getCurrentSession().update(supplier);
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
		public Supplier getSupplier(int supplierid) 
		{
			Session session=sessionFactory.openSession();
			Supplier supplier=(Supplier)session.get(Supplier.class,supplierid);
			session.close();
			return supplier;
		}

		@Override
		public List<Supplier> getSuppliers()
		{
			Session session=sessionFactory.openSession();
			Query query=session.createQuery("from Supplier");
			List<Supplier> listSuppliers=(List<Supplier>)query.list();
			return listSuppliers;
		}
		
	
}