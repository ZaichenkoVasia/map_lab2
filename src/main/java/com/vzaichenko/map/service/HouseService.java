package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.House;

import java.util.List;

public interface HouseService {

    House save(House house);

    House findById(Long id);

    List<House> findAll();

    House update(House house);

    void deleteById(Long id);
}
