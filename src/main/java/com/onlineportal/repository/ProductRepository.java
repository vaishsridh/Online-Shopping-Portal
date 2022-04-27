package com.onlineportal.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlineportal.model.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer>{
	
	@Query("{'Category.name' :?0}")
	List<Product> findByCategory(String category);
}
