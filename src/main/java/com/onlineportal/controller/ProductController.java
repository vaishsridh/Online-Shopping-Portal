package com.onlineportal.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlineportal.model.Product;
import com.onlineportal.service.ProductService;


@RestController
//@CrossOrigin(origins = "localhost:8080")
@RequestMapping("/v1")
public class ProductController {
	
	private static final Logger log = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
		
	@PostMapping("/add-product")
	ResponseEntity<Product> addProduct(@RequestBody Product product){
		
		String status = productService.addProduct(product);
		log.info("Product added status - {}", status);
		return ResponseEntity.status(HttpStatus.CREATED).body(product);
	}
	
	@GetMapping("/product-list")
	List<Product> productList(){
		return productService.listAllProducts();
	}
	
	@GetMapping("/product-list/{category}")
	List<Product> productListByCategory(@PathVariable String category){
		return productService.listProductsByCategory(category);
	}
	
	@GetMapping("/product-list/{id}")
	Product productByID(@PathVariable Integer id){
		return productService.productByID(id);
	}
	
	@PutMapping("/update-product")
	String updateProduct(@RequestBody Product product) {
		String response =  productService.updateProduct(product);
		return response;
	}
	
	@DeleteMapping("/product/{id}")
	String deleteProductByID(@PathVariable Integer id) {
		return productService.deleteProductByID(id);
	}
	
	
}
