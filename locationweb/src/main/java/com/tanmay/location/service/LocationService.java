package com.tanmay.location.service;

import com.tanmay.location.entities.Location;

import java.util.List;

/**
 * @author Tanmay
 * @date 30/11/19
 **/
public interface LocationService {

    Location save(Location location);

    Location update(Location location);

    void delete(Location location);

    Location getLocationById(int id);

    List<Location> getLocations();
}
