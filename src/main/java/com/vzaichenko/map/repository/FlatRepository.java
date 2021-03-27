package com.vzaichenko.map.repository;

import com.vzaichenko.map.entity.FlatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<FlatEntity, Long> {
}
