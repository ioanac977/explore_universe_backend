package com.explore.universe.dao;

import com.explore.universe.entity.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetDAO extends JpaRepository<Planet, Integer> {
}
