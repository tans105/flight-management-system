package com.tanmay.location.repo;

import com.tanmay.location.entities.Location;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author Tanmay
 * @date 30/11/19
 **/
public interface LocationRepository extends CrudRepository<Location, Integer> {

    @Query("select type, count(type) from com.tanmay.location.entities.Location group by type")
    public List<Object[]> findTypeAndCount();
}
