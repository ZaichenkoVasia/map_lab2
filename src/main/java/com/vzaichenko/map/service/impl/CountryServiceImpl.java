package com.vzaichenko.map.service.impl;

import com.vzaichenko.map.domain.Country;
import com.vzaichenko.map.entity.CountryEntity;
import com.vzaichenko.map.repository.CountryRepository;
import com.vzaichenko.map.service.CountryService;
import com.vzaichenko.map.service.exception.IncorrectIdRuntimeException;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CountryServiceImpl implements CountryService {
    @PersistenceContext
    private final EntityManager entityManager;
    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    @Override
    public Country save(Country country) {
        return mapEntityToDTO(countryRepository.save(mapDTOToEntity(country)));
    }

    @Override
    public Country findById(Long id) {
        return mapEntityToDTO(countryRepository.findById(id)
                .orElseThrow(() -> new IncorrectIdRuntimeException("Incorrect id: " + id + " while find by id")));
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll().stream()
                .map(this::mapEntityToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public Country update(Country country) {
        return mapEntityToDTO(entityManager.merge(mapDTOToEntity(country)));
    }

    @Override
    public void deleteById(Long id) {
        countryRepository.deleteById(id);
    }

    private Country mapEntityToDTO(CountryEntity countryEntity) {
        return modelMapper.map(countryEntity, Country.class);
    }

    private CountryEntity mapDTOToEntity(Country country) {
        return modelMapper.map(country, CountryEntity.class);
    }
}
