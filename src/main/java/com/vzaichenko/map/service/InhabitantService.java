package com.vzaichenko.map.service;

import com.vzaichenko.map.domain.Citizen;
import com.vzaichenko.map.domain.Flat;
import com.vzaichenko.map.domain.Inhabitant;

import java.util.List;

public interface InhabitantService {

    Inhabitant save(Inhabitant inhabitant);

    Inhabitant findById(Long id);

    List<Inhabitant> findAll();

    Inhabitant update(Inhabitant inhabitant);

    void deleteById(Long id);

    List<Flat> findFlatsBySurnameOfCitizen(String surname);

    List<Citizen> findCitizensByNumberOfFlat(Integer number);
}
