package com.tanmay.flightreservation.repos;

import com.tanmay.flightreservation.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tanmay
 * @date 05/12/19
 **/
public interface FlightRepository extends JpaRepository<Flight, Long> {
}
