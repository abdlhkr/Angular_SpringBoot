package com.example.products.controller;


import com.example.products.dto.ProductCreateDTO;
import com.example.products.dto.ProductPriceUpdateDto;
import com.example.products.dto.ProductQuantityUpdateDto;
import com.example.products.model.ProductModel;
import com.example.products.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    ProductModel addProduct(@RequestBody ProductCreateDTO productCreateDTO) {
        return productService.createProduct(productCreateDTO);
    }

    @PutMapping("/quantity")
    ProductModel updateQuantity(@RequestBody ProductQuantityUpdateDto product) {
        return productService.updateQuantity(product);
    }

    @PutMapping("/price")
    ProductModel updatePrice(@RequestBody ProductPriceUpdateDto product) {
        return productService.updatePrice(product);
    }

    @GetMapping
    List<ProductModel> getAllProducts() {
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    void deleteProductById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
