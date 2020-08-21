package com.explore.universe.controller;

import com.explore.universe.entity.Planet;
import com.explore.universe.entity.Team;
import com.explore.universe.repository.TeamRepository;
import com.explore.universe.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/teams")
public class TeamController {

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public ApiResponse<List<Team>> getAllTeams(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Teams fetched successfully",teamRepository.findAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<Planet> getOneTeam(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "Team fetched successfully.",teamRepository.findById(id));
    }

}
