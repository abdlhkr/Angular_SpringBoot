package com.example.products.service;

import com.example.products.dto.ProductCreateDTO;
import com.example.products.dto.ProductPriceUpdateDto;
import com.example.products.dto.ProductQuantityUpdateDto;
import com.example.products.model.ProductModel;

import java.util.List;

public interface ProductService {
    List<ProductModel> findAll();
    ProductModel createProduct(ProductCreateDTO productCreateDTO);
    ProductModel updateQuantity(ProductQuantityUpdateDto productQuantityUpdateDto);
    ProductModel updatePrice(ProductPriceUpdateDto product);
    void deleteById(long id);
}
