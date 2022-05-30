package com.nguyenphitan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nguyenphitan.entity.Product;
import com.nguyenphitan.repository.ProductRepository;
import com.nguyenphitan.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	@Transactional(rollbackFor = {Exception.class})
	public void updateName(Long id, String name) throws Exception {
		Product product = productRepository.findById(id).get();
		product.setName(name);
		productRepository.save(product);
		throw new Exception("test");
//		throw new RuntimeException("no way");
	}

}
