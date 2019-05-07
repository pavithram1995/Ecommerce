package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class CartItem
{
	@Id
	@GeneratedValue
	private int cartId;
	private String username;
	private String productName;
	private int ProductId;
	private double Subtotal;
	private String PaymentStatus;
	private int quantity;
	
	public double getSubtotal() {
		return Subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.Subtotal= subtotal;
	}
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		this.ProductId= productId;
	}
	
	public String getPaymentStatus() {
		return PaymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.PaymentStatus= paymentStatus;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
