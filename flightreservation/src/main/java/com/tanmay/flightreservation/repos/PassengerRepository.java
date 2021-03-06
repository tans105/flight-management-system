package com.tanmay.flightreservation.repos;

import com.tanmay.flightreservation.entities.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tanmay
 * @date 05/12/19
 **/
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
}
