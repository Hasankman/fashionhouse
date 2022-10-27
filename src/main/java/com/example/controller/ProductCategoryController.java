package com.example.controller;

import java.util.List;


import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.ProductCategory;
import com.example.dto.ProductCategoryDTO;
import com.example.service.ProductCategorysService;

import lombok.AllArgsConstructor;



@RestController
@AllArgsConstructor
public class ProductCategoryController {
	
	@Autowired
	private ProductCategorysService service;
	
	@PostMapping("/addProductCat")
	public ProductCategoryDTO addProductCategorys(@RequestBody ProductCategory productcategory) {
		return service.addProductCategorys(productcategory);
	}
	
	@GetMapping("/allProductCat")
	public List<ProductCategoryDTO> getAllProductCategorys() {
		return service.getAllProductCategorys();
	}
	
	@GetMapping("/updateProductCat/{id}")
	public ProductCategoryDTO updateProductCategorys(@PathVariable Integer id, @RequestBody ProductCategory productcategory) {
		return service.updateProductCategory(id, productcategory);
	}
	
	@DeleteMapping("/deleteProductCat/{id}")
	public boolean deleteProductCategorys(@PathParam("id") Integer id) {
		return service.deleteProductCategory(id);
	}
	
	@GetMapping("/productCatById")
	public ProductCategoryDTO readProductCategoryById(@PathParam("id") Integer id) {
		return service.readById(id);
	}
	
	@GetMapping("/productCatByName")
	public ProductCategoryDTO readByName(@PathParam("name") String name){
		return service.readByName(name);
	}
}
