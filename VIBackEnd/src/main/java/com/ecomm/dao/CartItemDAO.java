package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.CartItem;

public interface CartItemDAO
{
	public boolean addCart(CartItem cartItem);
    public CartItem getCartItem(int cartItemId);
	public boolean deleteCartItem(CartItem cartItem);
	public boolean updateCartItem(CartItem cartItem);
	public List<CartItem> getCartItems(String username);
	public List<CartItem> paidCartItems(String username);
	
}
