package com.explore.universe.dao;

import com.explore.universe.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamDAO extends JpaRepository<Team, Integer> {
}
