package com.example.repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer>{
	
	@Query("select x from ProductCategory x where x.prodcatdesc=?1")
	Optional<ProductCategory> productCatByName(String prodcatdesc);
	
	
	
}