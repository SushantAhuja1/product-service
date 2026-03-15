package com.ecom.productservice.service.impl;

import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.dto.ProductResponseDTO;
import com.ecom.productservice.entity.Product;
import com.ecom.productservice.exception.ProductNotFoundException;
import com.ecom.productservice.mapper.ProductMapper;
import com.ecom.productservice.repository.ProductRepository;
import com.ecom.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponseDTO createProduct(ProductRequestDTO productRequestDTO) {
        Product product = productMapper.toEntity(productRequestDTO);
        Product savedProduct = productRepository.save(product);
        return productMapper.toResponseDTO(savedProduct);
    }

    @Override
    public List<ProductResponseDTO> getAllProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductResponseDTO> list = new ArrayList<>();
        for(Product product : products) {
            ProductResponseDTO productResponseDTO = productMapper.toResponseDTO(product);
            list.add(productResponseDTO);
        }
        return list;
    }

    @Override
    public ProductResponseDTO getProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id "+id));
        return productMapper.toResponseDTO(product);
    }

    @Override
    public void deleteProductById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id "+id));
        productRepository.delete(product);
    }

    @Override
    public ProductResponseDTO updateProductById(Long id, ProductRequestDTO productRequestDTO) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Product not found with id "+id));
        existingProduct.setPrice(productRequestDTO.getPrice());
        existingProduct.setName(productRequestDTO.getName());
        existingProduct.setQuantity(productRequestDTO.getQuantity());
        existingProduct.setDescription(productRequestDTO.getDescription());
        productRepository.save(existingProduct);
        return productMapper.toResponseDTO(existingProduct);
    }

}