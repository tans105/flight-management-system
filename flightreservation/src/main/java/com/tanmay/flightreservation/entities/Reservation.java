package com.tanmay.flightreservation.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * @author Tanmay
 * @date 05/12/19
 **/

@Entity
public class Reservation extends AbstractEntity{

    private Boolean checkedIn;
    private Integer numberOfBags;

    @OneToOne
    private Passenger passengerId;

    @OneToOne
    private Flight flight;


    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkedIn) {
        this.checkedIn = checkedIn;
    }

    public Integer getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(Integer numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    public Passenger getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(Passenger passengerId) {
        this.passengerId = passengerId;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
}
