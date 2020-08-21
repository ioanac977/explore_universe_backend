package com.explore.universe.dto;

import com.explore.universe.entity.Team;
import com.explore.universe.entity.Status;
public class PlanetDTO {

        private int id;
        private String name;
        private String description;
        private Status status;
        private Team team;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Status getStatus() {
        return status;
    }
}
