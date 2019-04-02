package com.gtluszcz.ejb.implementation.Commands;

import com.gtluszcz.ejb.implementation.Exceptions.PlaceNotFoundException;
import com.gtluszcz.ejb.implementation.Models.Cinema;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.io.Serializable;

@Stateless
@LocalBean
public class PlacesManager implements Serializable {
    @EJB
    Cinema cinema;

    public boolean isAvailable(int number) throws PlaceNotFoundException {
        return cinema.getSeatByNumber(number).isAvailable();

    }
}
