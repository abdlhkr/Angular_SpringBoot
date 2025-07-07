package com.example.products.service;

import com.example.products.dto.ProductCreateDTO;
import com.example.products.dto.ProductPriceUpdateDto;
import com.example.products.dto.ProductQuantityUpdateDto;
import com.example.products.model.ProductModel;
import com.example.products.repository.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImple implements ProductService {
    private final  ProductRepository repository;



    ProductModel toModel(ProductCreateDTO productCreateDTO) {
        ProductModel productModel = new ProductModel(
                0L,
                productCreateDTO.getProductName(),
                productCreateDTO.getQuantity(),
                productCreateDTO.getPrice()
        );
        return  productModel;
    }

    @Override
    public List<ProductModel> findAll() {
        return repository.findAll();
    }

    @Override
    public ProductModel createProduct(ProductCreateDTO productCreateDTO) {
        ProductModel productModel = toModel(productCreateDTO);
        return repository.save(productModel);
    }

    @Override
    public ProductModel updateQuantity(ProductQuantityUpdateDto product) {
        ProductModel model = repository.findById(product.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + product.getId()));
        model.setQuantity(product.getQuantity());
        return model;
    }

    @Override
    public ProductModel updatePrice(ProductPriceUpdateDto product) {
        ProductModel model = repository.findById(product.getId())
                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + product.getId()));
        model.setPrice(product.getPrice());
        return model;
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
