package com.ecomm.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.dao.SupplierDAO;
import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Controller
public class ProductController
{
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	SupplierDAO supplierDAO;

	@RequestMapping(value="/productPage", method=RequestMethod.GET)
	
	public ModelAndView supplierPage(Model m)
	{
		List<Product> prodlist=productDAO.listProducts();
		m.addAttribute("prolist", prodlist);
		List<Category> categlist=categoryDAO.getCategories();
		m.addAttribute("listcat",categlist);
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		m.addAttribute("listsup",suppllist);
		
		for(Product pro:prodlist)
		{
		System.out.println(">>>>>>>>>>>>>>>cat id : "+pro.getCategoryId());
		System.out.println(">>>>>>>>>>>>>>>sup id : "+pro.getSupplierId());
		System.out.println(">>>>>>>>>>>>>>>pro id : "+pro.getProductId());
		System.out.println(">>>>>>>>>>>>>>>pro name : "+pro.getProductName());
		System.out.println(">>>>>>>>>>>>>>>pro decsc : "+pro.getProdDesc());
		System.out.println(">>>>>>>>>>>>>>>pro stock : "+pro.getStock());
		System.out.println(">>>>>>>>>>>>>>>pro price : "+pro.getPrice());
		}
		
		ModelAndView mv=new ModelAndView("productPage", "prolist", prodlist);
		return mv;
	}
	
	@RequestMapping(value = "/productsave", method = RequestMethod.POST)
	public ModelAndView insertProductData(@RequestParam("proname") String name, @RequestParam("prodesc") String des,
			@RequestParam("stock") int stock,@RequestParam("price") int price,@RequestParam("pimage") MultipartFile pimage,
			@RequestParam("catid") int catid,@RequestParam("supid") int supid,Model m)
	{
		Product product=new Product();
		product.setProductName(name);
		product.setProdDesc(des);
		product.setStock(stock);
		product.setPrice(price);
		product.setCategoryId(catid);
		product.setSupplierId(supid);
		

		productDAO.addProduct(product);
		m.addAttribute(product);
		List<Product> prodlist=productDAO.listProducts();
		ModelAndView mv=new ModelAndView("productPage", "prolist", prodlist);
		
		
		String path="C:/Users/Pavithra/eclipse-workspace/VIFrontEnd/src/main/webapp/resources/images/";
		path=path+String.valueOf(product.getProductId())+".jpg";
		File image=new File(path);
		
		if(!pimage.isEmpty())
		{

			try 
			{
				byte[] fileBuffer=pimage.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();

			}
			
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
		

		
		m.addAttribute("prolist", prodlist);
		List<Category> categlist=categoryDAO.getCategories();
		m.addAttribute("listcat",categlist);
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		m.addAttribute("listsup",suppllist);
		
		return mv;
	}

	@RequestMapping("/deleteProduct/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId") int productId)
	{
		Product product=productDAO.getProduct(productId);
		
		productDAO.deleteProduct(product);
		List<Product> prodlist=productDAO.listProducts();
		ModelAndView mv=new ModelAndView("productPage", "prolist", prodlist);
		return mv;

	}

	@RequestMapping("/updateProduct/{productId}")
	public String updateProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
	
		List<Product> prodlist=productDAO.listProducts();
		m.addAttribute("listProducts",prodlist);
		List<Category> categlist=categoryDAO.getCategories(); 
		m.addAttribute("listcat",categlist);
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		m.addAttribute("listsup",suppllist);
		m.addAttribute("productInfo",product);
		
		return "updateProduct";
		
	}
	@RequestMapping(value = "/UpdateProduct", method = RequestMethod.POST)
	public ModelAndView updateProductToDb(@RequestParam("proid") int proid,@RequestParam("proname") String name, @RequestParam("prodesc") String des,
			@RequestParam("stock") int stock,@RequestParam("price") int price,@RequestParam("catid") int catid,
			@RequestParam("supid") int supid, @RequestParam("pimage") MultipartFile pimage,Model m)
	{
		Product product=productDAO.getProduct(proid);
		product.setProductName(name);
		product.setProdDesc(des);
		product.setStock(stock);
		product.setPrice(price);
		product.setCategoryId(catid);
		product.setSupplierId(supid);
		

		productDAO.updateProduct(product);
		
		
		List<Product> prodlist=productDAO.listProducts();
		ModelAndView mv=new ModelAndView("productPage", "prolist", prodlist);
		List<Category> categlist=categoryDAO.getCategories(); 
		m.addAttribute("listcat",categlist);
		List<Supplier> suppllist=supplierDAO.getSuppliers();
		m.addAttribute("listsup",suppllist);
		
		
		
		String path="C:/Users/Pavithra/eclipse-workspace/VIFrontEnd/src/main/webapp/resources/images/";
		path=path+String.valueOf(product.getProductId())+".jpg";
		
		File oldimage=new File(path);
		oldimage.delete();
		
		File image=new File(path);
		
		if(!pimage.isEmpty())
		{

			try 
			{
				byte[] fileBuffer=pimage.getBytes();	
				FileOutputStream fos=new FileOutputStream(image);
				BufferedOutputStream bs=new BufferedOutputStream(fos);
				bs.write(fileBuffer);
				bs.close();

			}
			
			catch (Exception e)
			{
				System.out.println("Exception Arised:"+e);
				e.printStackTrace();
			}
			
		}
		else
		{
			System.out.println("Problem Occured in File Uploading");
		}
		
		return mv;
		
	
	}
	
	@RequestMapping(value = "/displayProduct")
	public String displayProduct(Model m)
	{
		List<Product> prodlist=productDAO.listProducts();
		m.addAttribute("prolist",prodlist);
		return "DisplayProduct";
	}
	@RequestMapping(value = "/descriptionProduct/{productId}", method = RequestMethod.GET)
	public String descriptionProduct(@PathVariable("productId") int productId,Model m)
	{
		Product product=productDAO.getProduct(productId);
		List<Product> prodlist=productDAO.listProducts();
		m.addAttribute("listProducts",prodlist);
		m.addAttribute("dispinfo", product);
		return "DescriptionProduct";
	}
	
}

