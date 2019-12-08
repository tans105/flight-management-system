package com.tanmay.flightreservation.controller;

import com.tanmay.flightreservation.dto.ReservationUpdateRequest;
import com.tanmay.flightreservation.entities.Reservation;
import com.tanmay.flightreservation.repos.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Tanmay
 * @date 08/12/19
 **/

@RestController
public class ReservationRestController {

    @Autowired
    ReservationRepository resReop;

    @RequestMapping("/reservations/{id}")
    public Reservation findReservation(@PathVariable("id") Long id) {
        Reservation res = resReop.findById(id).get();
        return res;
    }


    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest req) {
        Reservation res = resReop.findById(req.getId()).get();
        res.setNumberOfBags(req.getNumberOfBags());
        res.setCheckedIn(req.isCheckIn());

        return resReop.save(res);
    }
}
