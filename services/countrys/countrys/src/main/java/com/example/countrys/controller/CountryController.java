package com.example.countrys.controller;

import com.example.countrys.dto.CountryGetPost;
import com.example.countrys.model.CountryModel;
import com.example.countrys.repository.CountryRepository;
import com.example.countrys.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/countrys")
@RequiredArgsConstructor
public class CountryController {
    private final CountryService service;

    @GetMapping("/getAll")
    List<CountryGetPost> getAllCountry() {
        return service.getAll();
    }

    @PostMapping("/addAll")
    List<CountryModel> addAllCountry(@RequestBody List<CountryGetPost> countrys) {
        return service.addAllCountry(countrys);
    }

    @PostMapping("/one")
    CountryModel addCountry(@RequestBody CountryGetPost country) {
        return service.createCountry(country);
    }

}
