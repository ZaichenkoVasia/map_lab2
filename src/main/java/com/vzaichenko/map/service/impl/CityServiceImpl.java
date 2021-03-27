package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.City;
import com.vzaichenko.map.entity.CityEntity;
import com.vzaichenko.map.repository.CityRepository;
import com.vzaichenko.map.service.CityService;
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
public class CityServiceImpl implements CityService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;

    @Override
    public City save(City city) {
        return mapEntityToDTO(cityRepository.save(mapDTOToEntity(city)));
    }

    @Override
    public City findById(Long id) {
        return mapEntityToDTO(cityRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public City update(City city) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(city)));
    }

    @Override
    public void deleteById(Long id) {
        cityRepository.deleteById(id);
    }

    private City mapEntityToDTO(CityEntity cityEntity) {
        return modelMapper.map(cityEntity, City.class);
    }

    private CityEntity mapDTOToEntity(City city) {
        return modelMapper.map(city, CityEntity.class);
    }
}
