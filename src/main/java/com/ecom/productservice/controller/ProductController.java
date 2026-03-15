package com.ecom.productservice.controller;

import com.ecom.productservice.dto.ProductRequestDTO;
import com.ecom.productservice.dto.ProductResponseDTO;
import com.ecom.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
    //create-product-controller
    @PostMapping
    public ProductResponseDTO createProductController(@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.createProduct(productRequestDTO);
    }
    //get-all-products-controller
    @GetMapping
    public List<ProductResponseDTO> getAllProductsController() {
        return productService.getAllProducts();
    }
    //get-product-by-id-controller
    @GetMapping("/{productId}")
    public ProductResponseDTO getProductByIdController(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
    //delete-product-by-id-controller
    @DeleteMapping("/{productId}")
    public String deleteProductByIdController(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return "Product with id "+productId+" is deleted successfully";
    }
    //update-product-by-id-controller
    @PutMapping("/{productId}")
    public ProductResponseDTO updateProductByIdController(@PathVariable Long productId,@Valid @RequestBody ProductRequestDTO productRequestDTO) {
        return productService.updateProductById(productId, productRequestDTO);
    }
}