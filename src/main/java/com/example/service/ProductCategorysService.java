package com.example.service;

import java.util.List;


import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.ProductCategory;
import com.example.dto.ProductCategoryDTO;
import com.example.exception.ProductCategoryNotFoundException;
import com.example.repository.ProductCategoryRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductCategorysService {
	
	@Autowired
	private ProductCategoryRepository repo;
	
	@Autowired
	private ModelMapper mapper;
	
	private ProductCategoryDTO mapToDTO(ProductCategory productcategory) {
		return this.mapper.map(productcategory, ProductCategoryDTO.class);
	}
	
	public ProductCategoryDTO addProductCategorys(ProductCategory productcategory) {
		ProductCategory saved = this.repo.save(productcategory);
		return this.mapToDTO(saved);
	}
	
	public List<ProductCategoryDTO> getAllProductCategorys() {
		return this.repo.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
	}
	
	public ProductCategoryDTO updateProductCategory(Integer id, ProductCategory productcategory) {
		Optional<ProductCategory> tempProductCategory = Optional.of(this.repo.findById(id).orElseThrow(ProductCategoryNotFoundException::new));
	
		ProductCategory existing = tempProductCategory.get();
		existing.setProdcatdesc(productcategory.getProdcatdesc());
		existing.setProducts(productcategory.getProducts());
		
		ProductCategory updated = this.repo.save(existing);
		return this.mapToDTO(updated);
	
	}
	
	public boolean deleteProductCategory(Integer id) {
		this.repo.findById(id).orElseThrow(ProductCategoryNotFoundException::new);
		this.repo.deleteById(id);
		boolean exists = this.repo.existsById(id);
		return !exists;
	}
	
	public ProductCategoryDTO readById(Integer id) {
		ProductCategory found =  this.repo.findById(id).orElseThrow(ProductCategoryNotFoundException::new);
		return this.mapToDTO(found);
	}
	
	public ProductCategoryDTO readByName(String name) {
		ProductCategory  found = this.repo.productCatByName(name).orElseThrow(ProductCategoryNotFoundException::new);
		return this.mapToDTO(found);
	}
}



