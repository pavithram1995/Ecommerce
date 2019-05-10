package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity//@Entity annotation defines that a class can be mapped to a table.
@Component//@Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context.
public class Category 
{
	@Id//Specifies the primary key of an entity.
	@GeneratedValue//@GeneratedValue annotation specifies that a value will be automatically generated for that field.

	
	private int categoryId;
	private String categoryDesc;
	private String categoryName;
	
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	public String getCategoryDesc()
	{
		return categoryDesc;
	}
	public void setCategoryDesc(String categoryDesc)
	{
		this.categoryDesc = categoryDesc;
	}
	public String getCategoryName()
	{
		return categoryName;
	}
	public void setCategoryName(String categoryName)
	{
		this.categoryName = categoryName;
	}
	
}	
