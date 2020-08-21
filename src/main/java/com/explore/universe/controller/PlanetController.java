package com.explore.universe.controller;

import com.explore.universe.dto.PlanetDTO;
import com.explore.universe.entity.Planet;
import com.explore.universe.repository.PlanetRepository;
import com.explore.universe.response.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private PlanetRepository planetRepository;

    @GetMapping
    public ApiResponse<List<Planet>> getAllPlanets(){
        return new ApiResponse<>(HttpStatus.OK.value(), "Planets fetched successfully",planetRepository.findAll());
    }
    @GetMapping("/{id}")
    public ApiResponse<Planet> getOnePlanet(@PathVariable int id){
        return new ApiResponse<>(HttpStatus.OK.value(), "Planet fetched successfully.",planetRepository.findById(id));
    }
    @PostMapping
    public ApiResponse<Planet> addPlanet(@RequestBody Planet planet){
        return new ApiResponse<>(HttpStatus.OK.value(), "Planet saved successfully.",planetRepository.save(planet));
    }
    @PutMapping("/{id}")
    public ApiResponse<PlanetDTO> update(@PathVariable int id, @RequestBody PlanetDTO planetDTO) {
        return new ApiResponse<>(HttpStatus.OK.value(), "Planet updated successfully.",  planetRepository.update(id, planetDTO));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable int id) {
        planetRepository.delete(id);
        return new ApiResponse<>(HttpStatus.OK.value(), "Planet deleted successfully.", null);
    }

    @GetMapping("image/{id}")
    public ResponseEntity<byte[]> fromDatabaseAsResEntity(@PathVariable("id") int id) throws SQLException {

        Planet dbFile = planetRepository.findById(id);
        byte[] imageBytes = null;
        if (dbFile!=null) {

            imageBytes = dbFile.getDataImage();
        }

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
    }



}
