package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.Citizen;
import com.vzaichenko.map.entity.CitizenEntity;
import com.vzaichenko.map.repository.CitizenRepository;
import com.vzaichenko.map.service.CitizenService;
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
public class CitizenServiceImpl implements CitizenService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final CitizenRepository citizenRepository;
    private final ModelMapper modelMapper;

    @Override
    public Citizen save(Citizen citizen) {
        return mapEntityToDTO(citizenRepository.save(mapDTOToEntity(citizen)));
    }

    @Override
    public Citizen findById(Long id) {
        return mapEntityToDTO(citizenRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<Citizen> findAll() {
        return citizenRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Citizen update(Citizen citizen) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(citizen)));
    }

    @Override
    public void deleteById(Long id) {
        citizenRepository.deleteById(id);
    }

    private Citizen mapEntityToDTO(CitizenEntity citizenEntity) {
        return modelMapper.map(citizenEntity, Citizen.class);
    }

    private CitizenEntity mapDTOToEntity(Citizen citizen) {
        return modelMapper.map(citizen, CitizenEntity.class);
    }
}
