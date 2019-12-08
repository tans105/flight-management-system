package com.tanmay.flightcheckin.integration;

import com.tanmay.flightcheckin.integration.dto.Reservation;
import com.tanmay.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author Tanmay
 * @date 08/12/19
 **/
@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String RESERVATION_REST_URL = "http://localhost:8080/flightreservation/reservations/";

    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(RESERVATION_REST_URL + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest req) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation res = restTemplate.postForObject(RESERVATION_REST_URL, req, Reservation.class);
        return res;
    }
}
