package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.City;

import java.util.List;

public interface CityService {

    City save(City city);

    City findById(Long id);

    List<City> findAll();

    City update(City city);

    void deleteById(Long id);
}
