package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Product {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int	productId;
	
	@NotNull
    @Size(min = 0, max = 100)
	private String productName;
	
	@Min(0)
	@Max(12)//I have created a maximum UK size that our fashion house produces
	private String productSize ;
	 
	@NotNull// All products should have a 
	private Float productPrice;
	
	private int productQuantity;
	
	@ManyToOne
	private String prodCatDesc;

	public Product(int productId, @NotNull @Size(min = 0, max = 100) String productName,
			@Min(0) @Max(12) String productSize, @NotNull Float productPrice, int productQuantity, String prodCatDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.prodCatDesc = prodCatDesc;
	}

	public Product() {
		super();
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productSize=" + productSize
				+ ", productPrice=" + productPrice + ", productQuantity=" + productQuantity + ", prodCatDesc="
				+ prodCatDesc + "]";
	}

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

	public String getProductSize() {
		return productSize;
	}

	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public String getProdCatDesc() {
		return prodCatDesc;
	}

	public void setProdCatDesc(String prodCatDesc) {
		this.prodCatDesc = prodCatDesc;
	};
	
	

}