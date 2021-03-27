package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.Street;

import java.util.List;

public interface StreetService {

    Street save(Street street);

    Street findById(Long id);

    List<Street> findAll();

    Street update(Street street);

    void deleteById(Long id);
}
