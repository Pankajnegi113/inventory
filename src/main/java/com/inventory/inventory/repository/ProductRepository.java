package com.inventory.inventory.repository;

import com.inventory.inventory.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface ProductRepository extends MongoRepository<Product, String> {
    List<Product> findByStatus(String status);
}
