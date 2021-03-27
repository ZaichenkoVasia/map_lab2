package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.Country;

import java.util.List;

public interface CountryService {

    Country save(Country country);

    Country findById(Long id);

    List<Country> findAll();

    Country update(Country country);

    void deleteById(Long id);
}
