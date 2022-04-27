package com.onlineportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlineportal.model.Product;
import com.onlineportal.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//List<Product> products = new ArrayList<>();

	public String addProduct(Product product) {
		//TODO: can add product validation as business logic here
		productRepository.save(product);
		return "SUCCESS";
	}

	public List<Product> listAllProducts() {
		return productRepository.findAll();
		//return products;
	}

	public List<Product> listProductsByCategory(String category) {
		return productRepository.findByCategory(category);
//		return products.stream()
//			.filter(p -> p.getCategory().getName().equalsIgnoreCase(category))
//			.collect(Collectors.toList());
	}

	public Product productByID(Integer id) {
		return productRepository.findById(id).get();
//		return products.stream()
//					.filter(p -> p.getId() == id)
//					.findAny()
//					.get();
	}

	public String updateProduct(Product product) {
		
		productRepository.save(product);	
		return "Product updation success";
	}
	
	public String deleteProductByID(Integer id) {
		productRepository.deleteById(id);
		return "Product deletion success";
	}

}
