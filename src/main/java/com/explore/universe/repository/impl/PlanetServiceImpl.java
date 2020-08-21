package com.explore.universe.repository.impl;


import com.explore.universe.dao.PlanetDAO;
import com.explore.universe.dto.PlanetDTO;
import com.explore.universe.entity.Planet;
import com.explore.universe.repository.PlanetRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "planetService")
public class PlanetServiceImpl  implements PlanetRepository {


    @Autowired
    private PlanetDAO planetDao;

    @Autowired
    private PlanetRepository planetRepository;

    @Override
    public Planet save(Planet planet)
    {
        return planetDao.save(planet);
    }

    @Override
    public List<Planet> findAll() {
        return planetDao.findAll();
    }

    @Override
    public void delete(int id) {

            planetDao.deleteById(id);

    }

    @Override
    public Planet findById(int id) {

        Optional<Planet> optionalPlanet = planetDao.findById(id);
        return optionalPlanet.isPresent() ? optionalPlanet.get() : null;
    }

    @Override
    public PlanetDTO update(int id, PlanetDTO planetDTO) {
            Planet editablePlanet = findById(id);
            if (editablePlanet != null) {
                BeanUtils.copyProperties(planetDTO, editablePlanet,  "team");
                planetDao.save(editablePlanet);
            }
        return planetDTO;

    }

}
