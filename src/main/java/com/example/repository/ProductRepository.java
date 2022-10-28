package com.example.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.domain.Product;


@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	@Query("select y from Product y where y.productName=?1")
	Optional<List<Product>> productByName(String productName);

	@Query("select z from Product z where z.productSize=?1")
	Optional<List<Product>> productBySize(String productSize);
	
	@Query("select c from Product c where c.productColour=?1")
	Optional<List<Product>> productByColour(String productColour);
}