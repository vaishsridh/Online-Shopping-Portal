package com.onlineportal.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.onlineportal.model.Product;

@Service
public class ProductService {
	
	List<Product> products = new ArrayList<>();

	public String addProduct(Product product) {
		//can add product validation as business logic here
		products.add(product);
		return "SUCCESS";
	}

	public List<Product> listAllProducts() {
		return products;
	}

	public List<Product> listProductsByCategory(String category) {
		return products.stream()
			.filter(p -> p.getCategory().getName().equalsIgnoreCase(category))
			.collect(Collectors.toList());
	}

	public Product productByID(Integer id) {
		return products.stream()
					.filter(p -> p.getId() == id)
					.findAny()
					.get();
	}

	public String updateProduct(Product product) {
		
		for(Product prod : products) {
			if(prod.getId().equals(product.getId())) {
				prod.setDiscount(product.getDiscount());
				prod.setDiscountDesc(product.getDiscountDesc());
				prod.setName(product.getName());
				prod.setPrice(product.getPrice());
				prod.setCategory(product.getCategory());
				
				return "Product Updated";
			}
		}
				
		return "Product updation failed";
	}
	
	public String deleteProductByID(Integer id) {
		for(Product prod : products) {
			if(prod.getId().equals(id)) {
				products.remove(prod);
				return "Product Deleted";
			}
		}
		return "Product deletion failed";
	}

}
