package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Product;

public class ProductCategoryDTO {
	
	private int prodCatId;
	
	private String prodCatDesc;
	
	private List<Product> products = new ArrayList<>();

	public ProductCategoryDTO(int prodCatId, String prodCatDesc, List<Product> products) {
		super();
		this.prodCatId = prodCatId;
		this.prodCatDesc = prodCatDesc;
		this.products = products;
	}

	public ProductCategoryDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ProductCategoryDTO [prodCatId=" + prodCatId + ", prodCatDesc=" + prodCatDesc + ", products=" + products
				+ "]";
	}

	public int getProdCatId() {
		return prodCatId;
	}

	public void setProdCatId(int prodCatId) {
		this.prodCatId = prodCatId;
	}

	public String getProdCatDesc() {
		return prodCatDesc;
	}

	public void setProdCatDesc(String prodCatDesc) {
		this.prodCatDesc = prodCatDesc;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
