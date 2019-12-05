package com.tanmay.location.controller;

import com.tanmay.location.entities.Location;
import com.tanmay.location.repo.LocationRepository;
import com.tanmay.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * @author Tanmay
 * @date 05/12/19
 **/

@RestController
@RequestMapping("/locations")
public class LocationRestController {

    @Autowired
    LocationRepository repository;

    @Autowired
    LocationService service;

    @GetMapping
    public List<Location> getLocations() {
        return (List<Location>) repository.findAll();
    }

    @PostMapping
    public Location createLocation(@RequestBody Location location) {
        return repository.save(location);
    }

    @PutMapping
    public Location updateLocation(@RequestBody Location location) {
        return repository.save(location);
    }

    @DeleteMapping("/{id}")
    public void deleteLocation(@PathVariable int id) {
        repository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Location findOne(@PathVariable int id) {
        return repository.findById(id).get();
    }
}
