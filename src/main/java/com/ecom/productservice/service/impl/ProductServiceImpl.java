package com.ecom.productservice.service.impl;

import com.ecom.productservice.entity.Product;
import com.ecom.productservice.exception.ProductNotFoundException;
import com.ecom.productservice.repository.ProductRepository;
import com.ecom.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()->new ProductNotFoundException("Product with id "+id+" not found"));
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id "+id+" not found"));
        productRepository.delete(product);
    }
}
