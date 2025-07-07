package com.example.countrys.service;

import com.example.countrys.dto.CountryGetPost;
import com.example.countrys.model.CountryModel;

import java.util.List;

public interface CountryService {
    List<CountryGetPost> getAll();
    CountryModel createCountry(CountryGetPost country);
    List<CountryModel> addAllCountry(List<CountryGetPost> country);

}
