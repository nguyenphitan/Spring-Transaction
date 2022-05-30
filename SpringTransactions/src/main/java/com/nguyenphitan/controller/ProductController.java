package com.nguyenphitan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nguyenphitan.entity.Product;
import com.nguyenphitan.repository.ProductRepository;
import com.nguyenphitan.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public List<Product> getAlls() {
	 	return productRepository.findAll();
	}
	
	@PutMapping("/{id}")
	public void update(@PathVariable("id") Long id, @RequestParam String name) throws Exception {
		productService.updateName(id, name);
	}
}
