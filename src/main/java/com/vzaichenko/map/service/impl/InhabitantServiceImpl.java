package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.Citizen;
import com.vzaichenko.map.domain.Flat;
import com.vzaichenko.map.domain.Inhabitant;
import com.vzaichenko.map.entity.InhabitantEntity;
import com.vzaichenko.map.repository.InhabitantRepository;
import com.vzaichenko.map.service.InhabitantService;
import com.vzaichenko.map.service.exception.IncorrectIdRuntimeException;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class InhabitantServiceImpl implements InhabitantService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final InhabitantRepository inhabitantRepository;
    private final ModelMapper modelMapper;

    @Override
    public Inhabitant save(Inhabitant inhabitant) {
        return mapEntityToDTO(inhabitantRepository.save(mapDTOToEntity(inhabitant)));
    }

    @Override
    public Inhabitant findById(Long id) {
        return mapEntityToDTO(inhabitantRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<Inhabitant> findAll() {
        return inhabitantRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Inhabitant update(Inhabitant inhabitant) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(inhabitant)));
    }

    @Override
    public void deleteById(Long id) {
        inhabitantRepository.deleteById(id);
    }

    @Override
    public List<Flat> findFlatsBySurnameOfCitizen(String surname) {
        return inhabitantRepository.findInhabitantEntitiesByCitizenEntity_Surname(surname).stream()
                .map(this::mapEntityToDTO)
                .map(Inhabitant::getFlat)
                .collect(Collectors.toList());
    }

    @Override
    public List<Citizen> findCitizensByNumberOfFlat(Integer number) {
        return inhabitantRepository.findInhabitantEntitiesByFlatEntity_Number(number).stream()
                .map(this::mapEntityToDTO)
                .map(Inhabitant::getCitizen)
                .collect(Collectors.toList());
    }

    private Inhabitant mapEntityToDTO(InhabitantEntity inhabitantEntity) {
        return modelMapper.map(inhabitantEntity, Inhabitant.class);
    }

    private InhabitantEntity mapDTOToEntity(Inhabitant inhabitant) {
        return modelMapper.map(inhabitant, InhabitantEntity.class);
    }
}
