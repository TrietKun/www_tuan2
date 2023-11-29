package com.example.tuan.services;

import com.example.tuan.models.Product;
import com.example.tuan.repositories.ProductRepository;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class ProductService {
    @Inject
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.getAll();
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }
}
