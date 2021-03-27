package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.Flat;
import com.vzaichenko.map.entity.FlatEntity;
import com.vzaichenko.map.repository.FlatRepository;
import com.vzaichenko.map.service.FlatService;
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
public class FlatServiceImpl implements FlatService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final FlatRepository flatRepository;
    private final ModelMapper modelMapper;

    @Override
    public Flat save(Flat flat) {
        return mapEntityToDTO(flatRepository.save(mapDTOToEntity(flat)));
    }

    @Override
    public Flat findById(Long id) {
        return mapEntityToDTO(flatRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<Flat> findAll() {
        return flatRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Flat update(Flat flat) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(flat)));
    }

    @Override
    public void deleteById(Long id) {
        flatRepository.deleteById(id);
    }

    private Flat mapEntityToDTO(FlatEntity flatEntity) {
        return modelMapper.map(flatEntity, Flat.class);
    }

    private FlatEntity mapDTOToEntity(Flat flat) {
        return modelMapper.map(flat, FlatEntity.class);
    }
}
