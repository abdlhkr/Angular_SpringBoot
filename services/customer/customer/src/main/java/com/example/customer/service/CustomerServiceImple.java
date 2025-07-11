package com.example.customer.service;

import com.example.customer.dto.CreateCustomerDTO;
import com.example.customer.errors.CustomerNotFoundException;
import com.example.customer.model.CustomerModel;
import com.example.customer.repository.CustomerRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class CustomerServiceImple implements CustomerService {
    private final CustomerRepo repository;


    public CustomerModel toEntity(CreateCustomerDTO customer) {
        return new CustomerModel(
                0L,
                customer.getFirstName(),customer.getLastName(),customer.getCountry(),customer.getEmail(), customer.getPhone()
        );
    }

    @Override
    public CustomerModel create(CreateCustomerDTO customer) {
        return repository.save(toEntity(customer));
    }

    @Override
    public List<CustomerModel> findAll() {
        return repository.findAll();
    }


    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
