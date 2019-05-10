package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.OrderDetail;

public interface OrderDetailDAO 
{

	public boolean ConfirmOrderDetail(OrderDetail OrderDetail);
	public List<OrderDetail> getOrder(String username);
	public OrderDetail getOrderId(int id);
	
}
