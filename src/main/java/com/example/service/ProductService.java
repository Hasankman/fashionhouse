package com.example.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.Product;
import com.example.dto.ProductDTO;
import com.example.exception.ProductNotFoundException;
import com.example.repository.ProductRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Service
@AllArgsConstructor
@Data
public class ProductService {
	
	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	private ProductDTO mapToDTO(Product product) {
		return this.mapper.map(product, ProductDTO.class);
	}
	
	public ProductDTO addProduct(Product product) {
		Product saved = this.repo.save(product);
		return this.mapToDTO(saved);
	}
	
	public List<ProductDTO> getAllProducts() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public ProductDTO updateProduct(Integer id, Product product) {
		Optional<Product> tempProduct = Optional.of(this.repo.findById(id)).orElseThrow(ProductNotFoundException::new);
		Product existing = tempProduct.get();
		
		existing.setProductName(product.getProductName());
		existing.setProductColour(product.getProductColour());
		existing.setProductSize(product.getProductSize());
		existing.setProductPrice(product.getProductPrice());
		existing.setProductQuantity(product.getProductQuantity());
		existing.setProductcategory(product.getProductcategory());
		
		Product updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	}
	
	public boolean deleteProduct(Integer id) {
		this.repo.findById(id).orElseThrow(ProductNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public ProductDTO readProductById(Integer id) {
		Product found = this.repo.findById(id).orElseThrow(ProductNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	public List<ProductDTO> readByName(String name) {
		List<Product> found = this.repo.productByName(name).orElseThrow(ProductNotFoundException::new);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ProductDTO> readBySize(String Size) {
		List<Product> found = this.repo.productBySize(Size).orElseThrow(ProductNotFoundException::new);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public List<ProductDTO> readByColour(String Colour) {
		List<Product> found = this.repo.productByColour(Colour).orElseThrow(ProductNotFoundException::new);
		return found.stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
}