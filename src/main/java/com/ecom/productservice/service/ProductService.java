package com.ecom.productservice.service;

import com.ecom.productservice.entity.Product;

import java.util.List;

public interface ProductService {
    //create-product-method
    Product createProduct(Product product);
    //get-all-products-method
    List<Product> getAllProducts();
    //get-product-by-id-method
    Product getProductById(Long id);
    //delete-product-by-id-method
    void deleteProductById(Long id);
}
