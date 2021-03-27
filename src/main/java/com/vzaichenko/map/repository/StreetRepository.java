package com.vzaichenko.map.repository;

import com.vzaichenko.map.entity.StreetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Long> {
}
