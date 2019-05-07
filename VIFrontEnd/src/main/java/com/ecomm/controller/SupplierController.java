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
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Supplier;

@Controller

public class SupplierController
{

	@RequestMapping(value="/supplier", method=RequestMethod.GET)

	public ModelAndView supplierPage()
	{
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		for(Supplier sup : suppllist)
		{
		System.out.println(">>>>>>>>>>>>>>>cat id : "+sup.getSupplierId());
		System.out.println(">>>>>>>>>>>>>>>cat name : "+sup.getSupplierName());
		System.out.println(">>>>>>>>>>>>>>>cat decsc : "+sup.getSupplierLocation());
		}
		
		ModelAndView mv=new ModelAndView("supplier", "suplist", suppllist);
		return mv;
	}
	@Autowired
	SupplierDAO supplierDAO;
	
	
	@RequestMapping(value = "/suppliersave", method = RequestMethod.POST)
	public ModelAndView insertSupplierData(@RequestParam("supname") String name, @RequestParam("suploc") String loc)
	{
		Supplier supplier=new Supplier();
		supplier.setSupplierName(name);
		supplier.setSupplierLocation(loc);

		supplierDAO.addSupplier(supplier);
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		ModelAndView mv=new ModelAndView("supplier", "suplist", suppllist);
		return mv;
	}
	@RequestMapping("/deleteSupplier/{supplierId}")
	public ModelAndView deleteCategory(@PathVariable("supplierId") int supplierId)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
		
		supplierDAO.deleteSupplier(supplier);
		
		//List<Category> listCategories=categoryDAO.getCategories();
		//m.addAttribute("listCategories",listCategories);
		boolean flag=false;
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		ModelAndView mv=new ModelAndView("supplier", "suplist", suppllist);
		return mv;

	}

	@RequestMapping("/updateSupplier/{supplierId}")
	public String updateSupplier(@PathVariable("supplierId") int supplierId,Model m)
	{
		Supplier supplier=supplierDAO.getSupplier(supplierId);
	
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		m.addAttribute("listSuppliers",suppllist);
		m.addAttribute("supplierInfo",supplier);
		
		return "updateSupplier";
		
	}
	
	@RequestMapping(value="/UpdateSupplier",method=RequestMethod.POST)
	public ModelAndView updateCategoryToDb(@RequestParam("supplierId") int id,@RequestParam("supname") String name, @RequestParam("suploc") String loc)
	{
		Supplier supplier=supplierDAO.getSupplier(id);
		supplier.setSupplierName(name);
		supplier.setSupplierLocation(loc);

		supplierDAO.updateSupplier(supplier);
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		ModelAndView mv=new ModelAndView("supplier", "suplist", suppllist);
		return mv;
	}
}
