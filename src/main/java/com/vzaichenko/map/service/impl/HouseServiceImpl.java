package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.Citizen;
import com.vzaichenko.map.domain.House;
import com.vzaichenko.map.entity.CitizenEntity;
import com.vzaichenko.map.entity.HouseEntity;
import com.vzaichenko.map.repository.HouseRepository;
import com.vzaichenko.map.service.HouseService;
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
public class HouseServiceImpl implements HouseService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final HouseRepository houseRepository;
    private final ModelMapper modelMapper;

    @Override
    public House save(House house) {
        return mapEntityToDTO(houseRepository.save(mapDTOToEntity(house)));
    }

    @Override
    public House findById(Long id) {
        return mapEntityToDTO(houseRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<House> findAll() {
        return houseRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public House update(House house) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(house)));
    }

    @Override
    public void deleteById(Long id) {
        houseRepository.deleteById(id);
    }

    private House mapEntityToDTO(HouseEntity houseEntity) {
        return modelMapper.map(houseEntity, House.class);
    }

    private HouseEntity mapDTOToEntity(House house) {
        return modelMapper.map(house, HouseEntity.class);
    }
}
