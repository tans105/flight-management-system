package com.tanmay.flightreservation.service;

import com.tanmay.flightreservation.dto.ReservationRequest;
import com.tanmay.flightreservation.entities.Flight;
import com.tanmay.flightreservation.entities.Passenger;
import com.tanmay.flightreservation.entities.Reservation;
import com.tanmay.flightreservation.repos.FlightRepository;
import com.tanmay.flightreservation.repos.PassengerRepository;
import com.tanmay.flightreservation.repos.ReservationRepository;
import com.tanmay.flightreservation.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Tanmay
 * @date 05/12/19
 **/

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    FlightRepository flightRepo;

    @Autowired
    PassengerRepository passRepo;

    @Autowired
    ReservationRepository resRepo;

    @Autowired
    PDFGenerator pdfGenerator;

    @Override
    public Reservation bookFlight(ReservationRequest request) {

        //make payment
        Long flightId = request.getFlightId();
        Flight flight = flightRepo.findById(flightId).get();

        Passenger passenger = new Passenger();
        passenger.setEmail(request.getPassengerEmail());
        passenger.setFirstName(request.getPassengerFirstName());
        passenger.setLastName(request.getPassengerLastName());
        passenger.setPhone(request.getPassengerPhone());
        passenger.setMiddleName(request.getPassengerMiddleName());

        Passenger savedPassenger = passRepo.save(passenger);

        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(passenger);
        reservation.setCheckedIn(true);
        reservation.setNumberOfBags(2);

        Reservation savedReservation = resRepo.save(reservation);
        pdfGenerator.generateItinerary(savedReservation, "/Users/awata02/reservation_" + savedReservation.getId() + ".pdf");

        return savedReservation;
    }
}
