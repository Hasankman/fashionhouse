package com.example.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ProductCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer prodCatId;
	
	private String prodcatdesc;
	
	@OneToMany(mappedBy = "productcategory", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private List<Product> products = new ArrayList<>();

	public ProductCategory(Integer prodCatId, String prodcatdesc, List<Product> products) {
		super();
		this.prodCatId = prodCatId;
		this.prodcatdesc = prodcatdesc;
		this.products = products;
	}

	public ProductCategory() {
		super();
	}

	@Override
	public String toString() {
		return "ProductCategory [prodCatId=" + prodCatId + ", prodcatdesc=" + prodcatdesc + ", products=" + products
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

