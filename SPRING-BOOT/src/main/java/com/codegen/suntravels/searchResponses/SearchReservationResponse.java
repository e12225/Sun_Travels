package com.codegen.suntravels.searchResponses;

import com.codegen.suntravels.logics.AvailableReservationComposer;

import java.util.List;

/**
 * Created by DELL on 11/16/2017.
 */
public class SearchReservationResponse {

    private List<AvailableReservationComposer> availableReservations;
    private String reservationsAvailability;
    private Integer numberOfAvailableReservations;

    public List<AvailableReservationComposer> getAvailableReservations() {
        return availableReservations;
    }

    public void setAvailableReservations(List<AvailableReservationComposer> availableReservations) {
        this.availableReservations = availableReservations;
    }

    public Integer getNumberOfAvailableReservations() {
        return numberOfAvailableReservations;
    }

    public void setNumberOfAvailableReservations(Integer numberOfAvailableReservations) {
        this.numberOfAvailableReservations = numberOfAvailableReservations;
    }

    public String getReservationsAvailability() {
        return reservationsAvailability;
    }

    public void setReservationsAvailability(String reservationsAvailability) {
        this.reservationsAvailability = reservationsAvailability;
    }

    @Override
    public String toString() {
        return "SearchReservationResponse{" +
                "availableReservations=" + availableReservations +
                ", reservationsAvailability='" + reservationsAvailability + '\'' +
                ", numberOfAvailableReservations=" + numberOfAvailableReservations +
                '}';
    }
}
