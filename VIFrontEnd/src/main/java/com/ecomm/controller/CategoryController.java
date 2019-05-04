package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

@Controller

public class CategoryController
{

	@RequestMapping(value="/category",method=RequestMethod.GET)
	public ModelAndView categoryPage()
	{
		List<Category> categlist=categoryDAO.getCategories();
		for(Category cat : categlist)
		{
		System.out.println(">>>>>>>>>>>>>>>cat id : "+cat.getCategoryId());
		System.out.println(">>>>>>>>>>>>>>>cat name : "+cat.getCategoryName());
		System.out.println(">>>>>>>>>>>>>>>cat decsc : "+cat.getCategoryDesc());
		}
		
		ModelAndView mv=new ModelAndView("category", "catlist", categlist);
		return mv;
	}
	@Autowired
	CategoryDAO categoryDAO;
	
	
	@RequestMapping(value = "/categorysave", method = RequestMethod.POST)
	public ModelAndView insertCategoryData(@RequestParam("catname") String name, @RequestParam("catdesc") String desc)
	{
		Category category = new Category();
		category.setCategoryName(name);
		category.setCategoryDesc(desc);

		categoryDAO.addCategory(category);
		List<Category> categlist=categoryDAO.getCategories();
		ModelAndView mv=new ModelAndView("category", "catlist", categlist);
		return mv;
	}
	@RequestMapping("/deleteCategory/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId") int categoryId)
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		//List<Category> listCategories=categoryDAO.getCategories();
		//m.addAttribute("listCategories",listCategories);
		boolean flag=false;
		List<Category> categlist=categoryDAO.getCategories();
		ModelAndView mv=new ModelAndView("category", "catlist", categlist);
		return mv;

	}

	@RequestMapping("/updateCategory/{categoryId}")
	public String updateCategory(@PathVariable("categoryId") int categoryId,Model m)
	{
		Category category=categoryDAO.getCategory(categoryId);
	
		List<Category> categlist=categoryDAO.getCategories();
		m.addAttribute("listCategories",categlist);
		m.addAttribute("categoryInfo",category);
		
		return "updateCategory";
		
	}
	
	@RequestMapping(value="/UpdateCategory",method=RequestMethod.POST)
	public ModelAndView updateCategoryToDb(@RequestParam("catid") int id,@RequestParam("catname") String name, @RequestParam("catdesc") String desc)
	{
		Category category = categoryDAO.getCategory(id);
		category.setCategoryName(name);
		category.setCategoryDesc(desc);

		categoryDAO.updateCategory(category);
		List<Category> categlist=categoryDAO.getCategories();
		ModelAndView mv=new ModelAndView("category", "catlist", categlist);
		return mv;
	}
}
