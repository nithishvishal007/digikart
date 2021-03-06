package com.niit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Entity
@Component
@Table(name="Product")
public class Product {
	@Id
	@Column(name="PRODUCT_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int  productid;
	@NotEmpty(message="Product name cannot be empty")
	private String productname;
	@NotEmpty(message="product description is mandatory")
	private String productDesc;
	@Min(value=1, message=" minimum value for price is 1" )
    private int price;
	private int categoryid;
	private int supplierid;
	@Min(value=0, message="minimum value cannot be less than zero")
	private int quantity;

	@Transient
	private MultipartFile pimage;
	
	public int getProductid() {
		return productid;
	}

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public int getSupplierid() {
		return supplierid;
	}

	public void setSupplierid(int supplierid) {
		this.supplierid = supplierid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String toString() {
	return "Product [productname="+productname+", productDesc="+productDesc+",price="+price+",Quantity="+quantity+"]";	
	}
	
	

}
