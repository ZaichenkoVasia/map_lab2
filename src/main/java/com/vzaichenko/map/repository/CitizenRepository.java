package com.vzaichenko.map.repository;

import com.vzaichenko.map.entity.CitizenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepository extends JpaRepository<CitizenEntity, Long> {
}
