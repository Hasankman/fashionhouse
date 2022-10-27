package com.example.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.domain.Product;

public class ProductCategoryDTO {
	
	private Integer prodCatId;
	
	private String prodcatdesc;
	
	private List<Product> products = new ArrayList<>();

	public ProductCategoryDTO(Integer prodCatId, String prodcatdesc, List<Product> products) {
		super();
		this.prodCatId = prodCatId;
		this.prodcatdesc = prodcatdesc;
		this.products = products;
	}

	public ProductCategoryDTO() {
		super();
	}

	@Override
	public String toString() {
		return "ProductCategorysDTO [prodCatId=" + prodCatId + ", prodcatdesc=" + prodcatdesc + ", products=" + products
				+ "]";
	}

	public Integer getProdCatId() {
		return prodCatId;
	}

	public void setProdCatId(Integer prodCatId) {
		this.prodCatId = prodCatId;
	}

	public String getProdcatdesc() {
		return prodcatdesc;
	}

	public void setProdcatdesc(String prodcatdesc) {
		this.prodcatdesc = prodcatdesc;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	
	
}
