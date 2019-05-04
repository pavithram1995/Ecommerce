package com.ecomm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest {
	static ProductDAO productDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		productDAO=(ProductDAO)context.getBean("productDAO");
	}
	@Ignore
	@Test
	public void addProductTest()
	{
		Product product=new Product();
		product.setProductId(1);
		product.setSupplierId(1);
		product.setCategoryId(1);
		product.setPrice(100);
		product.setStock(19);
		product.setProductName("Books");
		product.setProdDesc("Fiction books");
		assertTrue("Problem in Category Insertion",productDAO.addProduct(product));
	}
	
	@Ignore
	@Test
	public void getProductTest()
	{
		assertNotNull("Problem in get Category",productDAO.getProduct(43));
	}
	
	
	@Test
	public void deleteProductTest()
	{
		Product product=productDAO.getProduct(43);
		assertTrue("Problem in Deletion:",productDAO.deleteProduct(product));
	}
    @Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productDAO.getProduct(41);
		product.setPrice(699);
		product.setStock(9);
		assertTrue("Problem in Updation",productDAO.updateProduct(product));
	}
	
	@Test
	public void listProductTest()
	{   
		List<Product> listProducts=productDAO.listProducts();
		assertNotNull("No Products",listProducts);
		
		for(Product product:listProducts)
		{
			System.out.print(product.getStock()+":::");
			System.out.print(product.getPrice()+":::");
			System.out.println(product.getProdDesc());
		}
	}


}


