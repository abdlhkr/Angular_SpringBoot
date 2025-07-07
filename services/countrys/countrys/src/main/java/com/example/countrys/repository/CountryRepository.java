package com.example.countrys.repository;

import com.example.countrys.model.CountryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<CountryModel,String> {
}
