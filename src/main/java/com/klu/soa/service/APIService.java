package com.klu.soa.service;

import java.util.List;

import com.klu.soa.dto.ProductDTO;

public interface APIService {
	List<ProductDTO> displayAllProducts();
	ProductDTO displayProductById(int id);
	
}
