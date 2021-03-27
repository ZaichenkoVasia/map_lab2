package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.Flat;

import java.util.List;

public interface FlatService {

    Flat save(Flat flat);

    Flat findById(Long id);

    List<Flat> findAll();

    Flat update(Flat flat);

    void deleteById(Long id);
}
