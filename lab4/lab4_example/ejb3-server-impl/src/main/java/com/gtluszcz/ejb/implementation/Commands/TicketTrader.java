package com.gtluszcz.ejb.implementation.Commands;

import com.gtluszcz.ejb.implementation.Exceptions.NotEnoughMoneyException;
import com.gtluszcz.ejb.implementation.Exceptions.PlaceNotFoundException;
import com.gtluszcz.ejb.implementation.Exceptions.PlaceAlreadyTakenException;
import com.gtluszcz.ejb.implementation.Models.Cinema;

import javax.ejb.*;
import java.io.Serializable;

@Stateful
@LocalBean
public class TicketTrader implements Serializable {
    @EJB
    Cinema cinema;

    private int wallet = 10000;

    public void buyTicket(int number) throws PlaceNotFoundException, PlaceAlreadyTakenException, NotEnoughMoneyException {
        internalBuyTicket(number);
    }

    private void internalBuyTicket(int number) throws PlaceNotFoundException, NotEnoughMoneyException, PlaceAlreadyTakenException {
        int price = cinema.getPlacePrice(number);

        if (price > wallet) {
            throw new NotEnoughMoneyException(String.format("Place #%d is too expensive.", number));
        }

        cinema.reservePlace(number);
        wallet -= price;
    }

    public int getWallet() {
        return wallet;
    }
}
