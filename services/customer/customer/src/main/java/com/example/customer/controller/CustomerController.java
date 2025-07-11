package com.example.customer.controller;

import com.example.customer.dto.CreateCustomerDTO;
import com.example.customer.model.CustomerModel;
import com.example.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/customer")
public class CustomerController {
    private final CustomerService service;

    CustomerController(CustomerService service) {
        this.service = service;
    }
    @GetMapping
    public List<CustomerModel> findAll() {
        return service.findAll();
    }

    @PostMapping
    public CustomerModel create(@RequestBody CreateCustomerDTO customer) {
        return service.create(customer);
    }

    @DeleteMapping
    public void deleteById(@RequestBody long id) {
        service.deleteById(id);
    }
}
