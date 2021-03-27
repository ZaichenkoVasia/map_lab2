package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.Street;
import com.vzaichenko.map.entity.StreetEntity;
import com.vzaichenko.map.repository.StreetRepository;
import com.vzaichenko.map.service.StreetService;
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
public class StreetServiceImpl implements StreetService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final StreetRepository streetRepository;
    private final ModelMapper modelMapper;

    @Override
    public Street save(Street street) {
        return mapEntityToDTO(streetRepository.save(mapDTOToEntity(street)));
    }

    @Override
    public Street findById(Long id) {
        return mapEntityToDTO(streetRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<Street> findAll() {
        return streetRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Street update(Street street) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(street)));
    }

    @Override
    public void deleteById(Long id) {
        streetRepository.deleteById(id);
    }

    private Street mapEntityToDTO(StreetEntity streetEntity) {
        return modelMapper.map(streetEntity, Street.class);
    }

    private StreetEntity mapDTOToEntity(Street street) {
        return modelMapper.map(street, StreetEntity.class);
    }
}
