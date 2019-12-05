package com.tanmay.flightreservation.controller;

import com.tanmay.flightreservation.repos.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @author Tanmay
 * @date 05/12/19
 **/

@Controller
public class FlightController {

    @Autowired
    FlightRepository flightRepo;

    @RequestMapping(value = "findFlights", method = RequestMethod.POST)
    public String findFlights(@RequestParam String from, @RequestParam String to, @RequestParam @DateTimeFormat(pattern = "MM-dd-yyyy") Date departureDate, ModelMap map) {
        System.out.println(from + " " + to + " " + departureDate);
        map.addAttribute("flights", flightRepo.findFlights(from, to, departureDate));
        return "displayFlights";
    }
}
