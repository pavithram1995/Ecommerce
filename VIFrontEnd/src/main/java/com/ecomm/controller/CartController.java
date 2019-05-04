package com.ecomm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

@Controller
public class CartController
{
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	CartItemDAO cartDAO;
	
	
	
@RequestMapping(value="/addToCart")
	
	public String CartPage(Model m)
	{
	
//	List<Product> prodlist=productDAO.listProducts();
//	m.addAttribute("prolist", prodlist);
	return "Cart";
	
	}
}
