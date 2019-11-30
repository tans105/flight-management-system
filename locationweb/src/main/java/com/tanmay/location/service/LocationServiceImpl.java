package com.tanmay.location.service;

import com.tanmay.location.entities.Location;
import com.tanmay.location.repo.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Tanmay
 * @date 30/11/19
 **/

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository repository;

    public LocationRepository getRepository() {
        return repository;
    }

    public void setRepository(LocationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Location save(Location location) {
        return repository.save(location);
    }

    @Override
    public Location update(Location location) {
        return repository.save(location);
    }

    @Override
    public void delete(Location location) {
        repository.delete(location);
    }

    @Override
    public Location getLocationById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public List<Location> getLocations() {
        Iterable<Location> itr = repository.findAll();
        Iterator<Location> iterator = itr.iterator();
        List<Location> locations = new ArrayList<>();
        while (iterator.hasNext()) {
            locations.add(iterator.next());
        }
        return locations;
    }
}
