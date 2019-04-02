package com.gtluszcz.ejb.client;

import com.gtluszcz.ejb.implementation.Exceptions.NotEnoughMoneyException;
import com.gtluszcz.ejb.implementation.Exceptions.PlaceNotFoundException;
import com.gtluszcz.ejb.implementation.Exceptions.PlaceAlreadyTakenException;
import com.gtluszcz.ejb.implementation.Models.Place;
import com.gtluszcz.ejb.implementation.Commands.PlacesManager;
import com.gtluszcz.ejb.implementation.Models.Cinema;
import com.gtluszcz.ejb.implementation.Commands.TicketTrader;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named("CinemaView")
@SessionScoped
public class CinemaView implements Serializable {
    @EJB
    private TicketTrader ticketTrader;

    @EJB
    private PlacesManager placesManager;

    @EJB
    private Cinema cinema;

    private String error;


    public List<Place> getPlaces() {
        return cinema.getPlaceList();
    }

    public boolean isPlaceAvailable(int number) {
        try {
            return placesManager.isAvailable(number);
        } catch (PlaceNotFoundException e) {
            error = e.getMessage();
        }
        return false;
    }

    public void buy(int number) {
        System.out.println(number);

        try {
            ticketTrader.buyTicket(number);
        } catch (NotEnoughMoneyException | PlaceNotFoundException | PlaceAlreadyTakenException e) {
            error = e.getMessage();
        }
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getWallet() {
        return ticketTrader.getWallet();
    }
}
