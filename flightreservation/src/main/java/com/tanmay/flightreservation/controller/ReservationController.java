package com.tanmay.flightreservation.controller;

import com.tanmay.flightreservation.dto.ReservationRequest;
import com.tanmay.flightreservation.entities.Flight;
import com.tanmay.flightreservation.entities.Reservation;
import com.tanmay.flightreservation.repos.FlightRepository;
import com.tanmay.flightreservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * @author Tanmay
 * @date 05/12/19
 **/

@Controller
public class ReservationController {

    @Autowired
    FlightRepository flightRepo;

    @Autowired
    ReservationService service;

    @RequestMapping("showCompleteReservation")
    public String showCompleteReservation(@RequestParam Long flightId, ModelMap map) {
        Optional<Flight> flight = flightRepo.findById(flightId);
        map.addAttribute("flight",flight.get());
        return "completeReservation";
    }

    @RequestMapping(value = "completeReservation", method = RequestMethod.POST)
    public String completeReservation(ReservationRequest request, ModelMap map) {
        Reservation reservation = service.bookFlight(request);
        map.addAttribute("msg", "Reserved Successfully, ID:" + reservation.getId());
        return "reservationConfirmation";
    }
}
