package com.klu.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klu.soa.dto.ProductDTO;
import com.klu.soa.service.APIService;

@RestController
@RequestMapping("/product")
public class APIController {
	
	@Autowired
	private APIService service;
	
	@GetMapping("/displayAllProducts")
	public List<ProductDTO> displayAllProducts() {
		
		return service.displayAllProducts();
	}
	
	@GetMapping("/display/{id}")
	public ProductDTO displayProductById(@PathVariable int id) {
		return service.displayProductById(id);
	}
}
