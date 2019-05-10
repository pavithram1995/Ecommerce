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

@Controller//The @Controller annotation is used to mark any java class as a controller class.Controllers act as an interface between Model and View components

public class CategoryController
{

	@RequestMapping(value="/category",method=RequestMethod.GET)//The @RequestMapping annotation is used to map the web request "/userRegistration.htm" to the UserController class.
	public ModelAndView categoryPage()//The Model component corresponds to all the data-related logic that the user works with.The View component is used for all the UI logic of the application.
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
	//@RequestParam is used to get the request parameters from URL(Uniform Resource Locator), also known as query parameters.It is used to extract values from the HTTP request
	{
		Category category = new Category();
		category.setCategoryName(name);
		category.setCategoryDesc(desc);

		categoryDAO.addCategory(category);
		List<Category> categlist=categoryDAO.getCategories();
		ModelAndView mv=new ModelAndView("category", "catlist", categlist);//ModelAndView(String viewName,String modelName,Object modelObject)
		return mv;
	}
	@RequestMapping("/deleteCategory/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId") int categoryId)//@PathVariable extracts values from URI.(Uniform Resource Identifier).It is used to extract values from the HTTP request
	{
		Category category=categoryDAO.getCategory(categoryId);
		
		categoryDAO.deleteCategory(category);
		
		
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
