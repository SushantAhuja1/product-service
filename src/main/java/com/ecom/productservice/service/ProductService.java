package com.ecom.productservice.service;

import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.dto.ProductResponseDTO;

import java.util.List;

public interface ProductService {
    //create-product-method
    ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO);
    //get-all-products-method
    List<ProductResponseDTO> getAllProducts();
    //get-product-by-id-method
    ProductResponseDTO getProductById(Long id);
    //delete-product-by-id-method
    void deleteProductById(Long id);
    //update-product-by-id-method
    ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO);
}