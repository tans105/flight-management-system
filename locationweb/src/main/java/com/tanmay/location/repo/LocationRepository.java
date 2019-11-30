package com.tanmay.location.repo;

import com.tanmay.location.entities.Location;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Tanmay
 * @date 30/11/19
 **/
public interface LocationRepository extends CrudRepository<Location, Integer> {

}
