package com.example.customer.service;

import com.example.customer.dto.CreateCustomerDTO;
import com.example.customer.model.CustomerModel;

import java.util.List;

public interface CustomerService {
    CustomerModel create(CreateCustomerDTO customer);
    List<CustomerModel> findAll();
    void deleteById(long id);
}
