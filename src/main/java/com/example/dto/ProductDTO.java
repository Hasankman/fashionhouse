package com.example.dto;

public class ProductDTO {
	private int	productId;
	private String productName;
	private String productSize ;
	private Float productPrice;
	private int productQuantity;
	private String prodCatDesc;
	
	public ProductDTO(int productId, String productName, String productSize, Float productPrice, int productQuantity,
			String prodCatDesc) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productSize = productSize;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
		this.prodCatDesc = prodCatDesc;
	}

	public ProductDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ProductDTO [productId=" + productId + ", productName=" + productName + ", productSize=" + productSize
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
	}
	
	
}
