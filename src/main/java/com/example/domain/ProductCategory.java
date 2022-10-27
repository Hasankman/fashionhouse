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
	private int prodCatId;
	
	private String prodCatDesc;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	//@JsonManagedReference
	@JsonIgnore
	private List<Product> products = new ArrayList<>();

	public ProductCategory(int prodCatId, String prodCatDesc, List<Product> products) {
		super();
		this.prodCatId = prodCatId;
		this.prodCatDesc = prodCatDesc;
		this.products = products;
	}

	public ProductCategory() {
		super();
	}

	@Override
	public String toString() {
		return "ProductCategory [prodCatId=" + prodCatId + ", prodCatDesc=" + prodCatDesc + ", products=" + products
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
