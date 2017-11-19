package com.codegen.suntravels.logics;

import org.springframework.stereotype.Component;

/**
 * Created by DELL on 11/19/2017.
 */
@Component
public class MarkupCalculator {

    //TODO : change the formula if needed

    private final Double markUp = 0.15; // 15% of mark up is kept for the moment
    private Double cost = 0.00;
    private Double markedUpPrice = 0.00;

    public Double calculateMarkUpPrice(Double pricePerRoom, Integer numberOfAdults, Integer numberOfNights) {

        cost = pricePerRoom * numberOfNights * numberOfAdults;
        markedUpPrice = (cost * markUp) + cost;

        return markedUpPrice;
    }
}
