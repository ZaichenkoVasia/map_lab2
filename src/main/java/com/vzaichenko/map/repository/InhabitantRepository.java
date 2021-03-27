package com.vzaichenko.map.repository;

import com.vzaichenko.map.entity.InhabitantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InhabitantRepository extends JpaRepository<InhabitantEntity, Long> {

    List<InhabitantEntity> findInhabitantEntitiesByCitizenEntity_Surname(String citizenEntity_surname);

    List<InhabitantEntity> findInhabitantEntitiesByFlatEntity_Number(Integer flatEntity_number);
}
