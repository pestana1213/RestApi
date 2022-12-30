package com.example.Rest.API.Repositories;

import com.example.Rest.API.Components.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ProductRepo extends CrudRepository<Product, UUID> {
    Product save(Product product);
    Product getProductById(UUID id);
    void deleteById(UUID id);
}
