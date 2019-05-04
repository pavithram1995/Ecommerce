package com.ecomm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity //@Entity annotation defines that a class can be mapped to a table.
@Table // @Table annotation allows you to specify the details of the table that will be used to persist the entity in the database.
public class Product
{
	
	@Id //Specifies the primary key of an entity.
	@GeneratedValue //@GeneratedValue annotation specifies that a value will be automatically generated for that field.
	private int productId;
	private String productName;
	private int categoryId;
	private int supplierId;
	private int price;
	private int stock;
	private String prodDesc; 
	@Transient //@Transient annotation is used to indicate that a field is not to be persisted in the database
   private MultipartFile pimage;
    
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	public MultipartFile getPimage() {
		return pimage;
	}
	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}
	
}
