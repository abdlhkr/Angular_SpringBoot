package com.example.products.dto;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")
// update te aynı olucak farklı olarak sadece id alıcak
public class ProductCreateDTO {
    private String productName;
    private int quantity;
    private double price;
}
