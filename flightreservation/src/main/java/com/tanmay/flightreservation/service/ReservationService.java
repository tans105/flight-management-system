package com.tanmay.flightreservation.service;

import com.tanmay.flightreservation.dto.ReservationRequest;
import com.tanmay.flightreservation.entities.Reservation;

/**
 * @author Tanmay
 * @date 05/12/19
 **/
public interface ReservationService {
    Reservation bookFlight(ReservationRequest request);
}
