package com.example.exception;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Product does not exist with that ID")
public class ProductNotFoundException extends EntityNotFoundException{
	public ProductNotFoundException () {
		
	}
	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
