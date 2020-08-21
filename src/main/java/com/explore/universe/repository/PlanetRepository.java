package com.explore.universe.repository;

import com.explore.universe.dto.PlanetDTO;
import com.explore.universe.entity.Planet;

import java.util.List;

public interface PlanetRepository {
    Planet save(Planet planet);
    List<Planet> findAll();
    void delete(int id);
    Planet findById(int id);
    PlanetDTO update(int id, PlanetDTO planetDTO);

}