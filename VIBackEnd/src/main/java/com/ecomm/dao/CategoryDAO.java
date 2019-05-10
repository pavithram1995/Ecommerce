package com.ecomm.dao;
/*
 * A data access object (DAO) is an object that provides an abstract interface to some type of database or other persistence mechanism. 
 * By mapping application calls to the persistence layer, the DAO provides some specific data operations without exposing details of the database.
 */

import java.util.List;

import com.ecomm.model.Category;

public interface CategoryDAO
{
	public boolean addCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	public Category getCategory(int categoryid);
	public List<Category> getCategories();

}
