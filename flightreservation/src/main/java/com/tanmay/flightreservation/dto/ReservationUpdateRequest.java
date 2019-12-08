package com.tanmay.flightreservation.dto;

/**
 * @author Tanmay
 * @date 08/12/19
 **/
public class ReservationUpdateRequest {
    private Long id;
    private boolean checkIn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    private int numberOfBags;
}
