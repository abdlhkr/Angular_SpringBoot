package com.example.customer.repository;

import com.example.customer.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerModel,Long> {
}
