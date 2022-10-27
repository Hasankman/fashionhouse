package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.domain.Product;



@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
//	@Query("select b from Band b where b.name=?1")
//	Optional<Band> bandByName(String name);
	
}