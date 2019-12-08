package com.tanmay.flightcheckin.controller;

import com.tanmay.flightcheckin.integration.ReservationRestClient;
import com.tanmay.flightcheckin.integration.dto.Reservation;
import com.tanmay.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Tanmay
 * @date 08/12/19
 **/

@Controller
public class CheckinController {

    @Autowired
    ReservationRestClient restClient;

    @RequestMapping("/showStartCheckin")
    public String showStartCheckin() {
        return "startCheckin";
    }

    @RequestMapping("/startCheckin")
    public String startCheckin(@RequestParam("reservationId") Long reservationId, ModelMap map) {
        Reservation res = restClient.findReservation(reservationId);
        map.addAttribute("reservation", res);
        return "displayReservationDetails";
    }

    @RequestMapping("/completeCheckin")
    public String completeCheckin(@RequestParam("reservationId") Long reservationId,@RequestParam("numberOfBags") int numberOfBags) {
        ReservationUpdateRequest req = new ReservationUpdateRequest();
        req.setCheckIn(true);
        req.setId(reservationId);
        req.setNumberOfBags(numberOfBags);
        restClient.updateReservation(req);
        return "checkinConfirmation";
    }
}
