package com.ecomm.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class CategoryDAOTest 
{
	static CategoryDAO categoryDAO;

	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		
		categoryDAO=(CategoryDAO)context.getBean("categoryDAO");
	}
	@Ignore
	@Test
	public void addCategoryTest()
	{
		Category category=new Category();
		category.setCategoryId(1);
		category.setCategoryName("Shoes");
		category.setCategoryDesc("Pinky");
		assertTrue("Problem in Category Insertion",categoryDAO.addCategory(category));
	}
	
	@Test
	public void deleteCategoryTest()
	{
		Category category=categoryDAO.getCategory(4);
		assertTrue("Problem in Deletion:",categoryDAO.deleteCategory(category));
	}
	@Test
	public void updateCategoryTest()
	{
		Category category=categoryDAO.getCategory(2);
		category.setCategoryDesc("black");
		assertTrue("Problem in Deletion:",categoryDAO.updateCategory(category));
	}
	@Test
	public void listCategoriesTest()
	{
		List<Category> listcategories=categoryDAO.getCategories();
		assertNotNull("No Categories",listcategories);
		
		for(Category category:listcategories)
		{
			System.out.println(category.getCategoryId()+"-----");
			System.out.println(category.getCategoryName()+"-----");
			System.out.println(category.getCategoryDesc()+"-----");
		}
		
		
	}
	
}