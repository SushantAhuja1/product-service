package com.ecom.productservice.mapper;

import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.dto.ProductResponseDTO;
import com.ecom.productservice.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public Product toEntity(ProductRequestDTO productRequestDTO) {
        Product product = new Product();
        product.setDescription(productRequestDTO.getDescription());
        product.setName(productRequestDTO.getName());
        product.setPrice(productRequestDTO.getPrice());
        product.setQuantity(productRequestDTO.getQuantity());
        return product;
    }
    public ProductResponseDTO toResponseDTO(Product product) {
        if(product==null) return null;
        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setDescription(product.getDescription());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setQuantity(product.getQuantity());
        productResponseDTO.setId(product.getId());
        return productResponseDTO;
    }
}