package com.ecomm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.Product;

@Controller
public class CartController
{
	@Autowired
	ProductDAO productDAO;
	@Autowired
	CartItemDAO cartDAO;
	
		
	@RequestMapping(value="/Cart")
	public String displaycart(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		System.out.println(username);
		List<CartItem> listCarts=cartDAO.getCartItems(username);
		for(CartItem cat : listCarts)
		{
		System.out.println(">>>>>>>>>>>>>>>cat id : "+cat.getProductName());;
		}
		
		m.addAttribute("listCarts", listCarts);
		
		List<Product> prodlist=productDAO.listProducts();
		m.addAttribute("prolist", prodlist);
	
		
		return "Cart";
	}
	
	@RequestMapping(value = "/moveCart/{productId}",method = RequestMethod.POST)
	public String addCart(@PathVariable("productId") int proid,HttpSession session,Model m)
	{
		Product product=productDAO.getProduct(proid);
		
		boolean id=false;
		String username=(String)session.getAttribute("username");
		if(username==null)
		{
			
			return"login";
		}
		List<CartItem> listCarts=cartDAO.getCartItems(username);
		for(CartItem cart1: listCarts) 
		{
			if(proid==cart1.getProductId()) 
			{
				id=true;
				break;
			}
		}
		
		if(id==false)
		{
	    CartItem cart=new CartItem();
	    
		cart.setProductId(proid);
		cart.setQuantity(1);
		cart.setUsername(username);
		cart.setProductName(product.getProductName());
		cart.setPaymentStatus("NP");
		cart.setSubtotal(product.getPrice());
		
		cartDAO.addCart(cart);
		
		
		m.addAttribute("carlist", listCarts);
		m.addAttribute("grandtotal",grandTotal(listCarts));
		
		return "Cart";
		}
		else
		{
			{
				m.addAttribute("alert","This product is already added to cart");
			}
			
			return "DescriptionProduct";
		}
		
	}
	
	@RequestMapping(value="/deletecart/{cartId}")
	public String deletecart(@PathVariable("cartId") int cartid,HttpSession session,Model m)
	{
	String username=(String)session.getAttribute("username");
	CartItem cart=cartDAO.getCartItem(cartid);
	
    cartDAO.deleteCartItem(cart);
    
    List<CartItem> listCarts=cartDAO.getCartItems(username);
	m.addAttribute("listCarts", listCarts);
	m.addAttribute("grandtotal",grandTotal(listCarts));
		return "Cart";
	}
	
	@RequestMapping(value="/updatecart/{cartId}")
	public String updatecart(@PathVariable("cartId") int cartid,@RequestParam("quantity") int quantity,HttpSession session,Model m) 
	{
		String username=(String)session.getAttribute("username");
	CartItem cart=cartDAO.getCartItem(cartid);
	Product product=productDAO.getProduct(cart.getProductId());
	if(quantity>5) 
	{
		quantity=5;
		m.addAttribute("Cart",cart);
		m.addAttribute("alert","quantity can't be more than 5");
	}
	cart.setQuantity(quantity);
	int quant=(int)((quantity*product.getPrice())*100);
	double qua=(double)quant/100;
	cart.setSubtotal(qua);
    cartDAO.updateCartItem(cart);
    List<CartItem> listCarts=cartDAO.getCartItems(username);
	m.addAttribute("listCarts", listCarts);
	m.addAttribute("grandtotal",grandTotal(listCarts));
	
		return "Cart";
	}
	public double grandTotal(List<CartItem> listCarts)
	{
	
		double grandTotal1=0,grandTotal=0;
		try {
		for(CartItem cart: listCarts)
		{
			grandTotal1=grandTotal1+cart.getQuantity()*(productDAO.getProduct(cart.getProductId()).getPrice());
			
		}
		int grandTotal2=(int)(grandTotal1*100);
		grandTotal=(double)grandTotal2/100; 
		}
		catch(Exception e) {
			System.out.println("grand total error");
		}
		
		return grandTotal;
	}
	
}
