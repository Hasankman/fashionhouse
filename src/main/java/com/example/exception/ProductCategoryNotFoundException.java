package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product Category dose not exist with that ID")
public class ProductCategoryNotFoundException extends  EntityNotFoundException{
	
	public ProductCategoryNotFoundException () {
		
	}
	public ProductCategoryNotFoundException(String msg) {
		super(msg);
	}

}

