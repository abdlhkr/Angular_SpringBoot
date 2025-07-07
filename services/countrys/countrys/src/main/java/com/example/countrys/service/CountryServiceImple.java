package com.example.countrys.service;

import com.example.countrys.dto.CountryGetPost;
import com.example.countrys.model.CountryModel;
import com.example.countrys.repository.CountryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CountryServiceImple implements CountryService {
    private final CountryRepository repository;

    CountryGetPost toGetPost(CountryModel model) {
        return new CountryGetPost(model.getName(), model.getCountryCode());
    };

    CountryModel toModel(CountryGetPost countryGetPost) {
        CountryModel model = new CountryModel(
                null,
                countryGetPost.getName(),
                countryGetPost.getCountryCode()
        );
        return model;
    }

    @Override
    public List<CountryGetPost> getAll() {
         return repository.findAll().stream().map(this::toGetPost).collect(Collectors.toList());
    }

    @Override
    public CountryModel createCountry(CountryGetPost country) {
        return repository.save(toModel(country));
    }

    @Override
    public List<CountryModel> addAllCountry(List<CountryGetPost> country) {
        return repository.saveAll(country.stream()
                .map(this::toModel)
                .collect(Collectors
                        .toList()));
    }


}
