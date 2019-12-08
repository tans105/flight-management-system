package com.tanmay.flightcheckin.integration;

import com.tanmay.flightcheckin.integration.dto.Reservation;
import com.tanmay.flightcheckin.integration.dto.ReservationUpdateRequest;

/**
 * @author Tanmay
 * @date 08/12/19
 **/
public interface ReservationRestClient {
    public Reservation findReservation(Long id);
    public Reservation updateReservation(ReservationUpdateRequest req);
}
