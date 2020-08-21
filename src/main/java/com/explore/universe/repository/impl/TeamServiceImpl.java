package com.explore.universe.repository.impl;

import com.explore.universe.dao.PlanetDAO;
import com.explore.universe.dao.TeamDAO;
import com.explore.universe.entity.Team;
import com.explore.universe.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service(value = "teamService")
public class TeamServiceImpl  implements TeamRepository {

    @Autowired
    private TeamDAO teamDao;

    @Override
    public List<Team> findAll() {
        return teamDao.findAll();
    }

    @Override
    public Team findById(int id) {
        Optional<Team> optionalTeam = teamDao.findById(id);
        return optionalTeam.isPresent() ? optionalTeam.get() : null;
    }
}