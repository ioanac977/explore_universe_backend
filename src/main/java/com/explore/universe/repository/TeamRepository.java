package com.explore.universe.repository;

import com.explore.universe.entity.Team;

import java.util.List;

public interface TeamRepository {
    List<Team> findAll();
    Team findById(int id);


}