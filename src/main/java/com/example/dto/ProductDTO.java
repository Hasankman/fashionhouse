package com.example.dto;

import com.example.domain.ProductCategory;

public class ProductDTO {
	private Integer	productId;
	private String productName;
	private String productColour;
	private String productSize ;
	private Float productPrice;
	private Integer productQuantity;
	private ProductCategory productcategory;
	
	public ProductDTO(Integer productId, String productName, String productColour, String productSize,
			Float productPrice, Integer productQuantity, ProductCategory productcategory) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productColour = productColour;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.productcategory = productcategory;
	}
	public ProductDTO() {
		super();
	}
	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productColour="
				+ productColour + ", productSize=" + productSize + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + ", productcategory=" + productcategory + "]";
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductColour() {
		return productColour;
	}
	public void setProductColour(String productColour) {
		this.productColour = productColour;
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
	public Integer getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}
	public ProductCategory getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(ProductCategory productcategory) {
		this.productcategory = productcategory;
	}
	
	
	
	
	
}
