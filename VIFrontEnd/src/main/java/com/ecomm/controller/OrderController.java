package com.ecomm.controller;


import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.CartItemDAO;
import com.ecomm.dao.OrderDetailDAO;
import com.ecomm.dao.ProductDAO;
import com.ecomm.model.CartItem;
import com.ecomm.model.OrderDetail;

@Controller
public class OrderController
{
	@Autowired
	CartItemDAO cartDAO;
	
	@Autowired
	ProductDAO productDAO;
	
	@Autowired
	OrderDetailDAO orderDAO;
	
	@RequestMapping(value="/confirm",method=RequestMethod.GET)
	public String order(HttpSession session,Model m)
	{
		String username=(String)session.getAttribute("username");
		System.out.println(username);
		List<CartItem> listCarts=cartDAO.getCartItems(username);
		for(CartItem cart : listCarts)
		{
		System.out.println(">>>>>>>>>>>>>>>cart id : "+cart.getProductName());;
		}
		m.addAttribute("listCarts", listCarts);
				
		m.addAttribute("grandtotal",grandTotal(listCarts));
		System.out.println("Confirm mapped");
		
		return "confirmOrder";
	}
	public double grandTotal(List<CartItem> listCarts)
	{
	
		double grandTotal1=0,grandTotal=0;
		try
		{
		for(CartItem cart: listCarts)
		{
			grandTotal1=grandTotal1+cart.getQuantity()*(productDAO.getProduct(cart.getProductId()).getPrice());
			
		}
		int grandTotal2=(int)(grandTotal1*100);
		grandTotal=(double)grandTotal2/100; 
		}
		catch(Exception e) 
		{
			System.out.println("grand total error");
		}
		
		return grandTotal;
	}
	public double grandTotals(List<CartItem> listPaidCarts)
	{

		double grandTotal1=0,grandTotal=0;
		try {
		for(CartItem cart: listPaidCarts)
		{
			grandTotal1=grandTotal1+cart.getQuantity()*(productDAO.getProduct(cart.getProductId()).getPrice());
			
		}
		int grandTotal2=(int)(grandTotal1*100);
		grandTotal=(double)grandTotal2/100; 
		}
		catch(Exception e) {
			System.out.println("total error");
		}
		
		return grandTotal;
	}

	@RequestMapping("/PaymentConfirm")
	public String PaymentConfirm(@RequestParam("mode") String mode,@RequestParam("ShippingAdress") String Address,HttpSession session,Model m)
	{ 
		String username=(String)session.getAttribute("username");
		List<CartItem> listCartItems=cartDAO.getCartItems(username);
		
		for(CartItem Cart1:listCartItems)
		{
	         CartItem Cart2=cartDAO.getCartItem(Cart1.getCartId());
	         Cart2.setPaymentStatus("P");
	         cartDAO.updateCartItem(Cart2);
		}
		List <CartItem> listCart=cartDAO.paidCartItems(username);
		m.addAttribute("listcart", listCart);
		m.addAttribute("grandtotal", grandTotal(listCart));
		
		
		
				OrderDetail orderDetail=new OrderDetail();
				orderDetail.setTranType(mode);
				orderDetail.setOrderDate(String.format("%tc",new Date()));
				orderDetail.setTotalAmount(grandTotal(listCart));
				orderDetail.setUsername(username);
				orderDetail.setShippingAddr(Address);
				orderDAO.ConfirmOrderDetail(orderDetail);
				
							
			    
			    List<CartItem> listCartItems1=cartDAO.paidCartItems(username);
			    for(CartItem Cart3:listCartItems1)
				{
			         CartItem Cart4=cartDAO.getCartItem(Cart3.getCartId());
			         Cart4.setPaymentStatus("Paid");
			         cartDAO.updateCartItem(Cart4);
				}
			    
			   List<OrderDetail> listOrder=orderDAO.getOrder(username);
			   int id=0;
			   for(OrderDetail orderdetail:listOrder)
			   {
				   if(orderdetail.getOrderId()>id)
				   {
					   id=orderdetail.getOrderId();
				   }
			   }
			   OrderDetail order2=orderDAO.getOrderId(id);
			   m.addAttribute("orderdetail",order2);
				   
			   
			    
	         return "ThankYou";
		
	}
	
}
