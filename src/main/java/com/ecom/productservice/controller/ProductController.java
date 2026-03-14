package com.ecom.productservice.controller;

import com.ecom.productservice.entity.Product;
import com.ecom.productservice.service.ProductService;
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
    public Product createProductController(@RequestBody Product product) {
        return productService.createProduct(product);
    }
    //get-all-products-controller
    @GetMapping
    public List<Product> getAllProductsController() {
        return productService.getAllProducts();
    }
    //get-product-by-id-controller
    @GetMapping("/{productId}")
    public Product getProductByIdController(@PathVariable Long productId) {
        return productService.getProductById(productId);
    }
    //delete-product-by-id-controller
    @DeleteMapping("/{productId}")
    public String deleteProductByIdController(@PathVariable Long productId) {
        productService.deleteProductById(productId);
        return "Product with id "+productId+" is deleted successfully";
    }
}