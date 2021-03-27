package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.Citizen;

import java.util.List;

public interface CitizenService {

    Citizen save(Citizen citizen);

    Citizen findById(Long id);

    List<Citizen> findAll();

    Citizen update(Citizen citizen);

    void deleteById(Long id);
}
