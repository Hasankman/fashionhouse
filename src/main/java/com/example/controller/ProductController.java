package com.example.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.dto.ProductDTO;
import com.example.service.ProductService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping("addProducts")
	public ProductDTO addProduct(@RequestBody Product product) {
		return service.addProduct(product);
	}
	
	@GetMapping("allProducts")
	public List<ProductDTO> getAllProducts() {
		return service.getAllProducts();
	}
	
	@PutMapping("/updateProduct/{id}")
	public ProductDTO updateProduct(@PathVariable Integer id, @RequestBody Product product) {
	return service.updateProduct(id, product);
	}
	
	@DeleteMapping("/deleteProduct/{id}")
	public boolean deleteProduct(@PathVariable Integer id) {
		return service.deleteProduct(id);
	}
	
	@GetMapping("/productById")
	public ProductDTO readProductById(@PathParam("id") Integer id) {
		return service.readProductById(id);
	}
	
	@GetMapping("/productByName")
	public List<ProductDTO> readProductByName(@PathParam("name") String name) {
		return service.readByName(name);
	}
	
}

