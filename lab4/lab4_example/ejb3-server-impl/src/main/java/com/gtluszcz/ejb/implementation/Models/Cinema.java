package com.gtluszcz.ejb.implementation.Models;

import com.gtluszcz.ejb.implementation.Exceptions.PlaceNotFoundException;
import com.gtluszcz.ejb.implementation.Exceptions.PlaceAlreadyTakenException;

import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.Singleton;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Singleton
@LocalBean
public class Cinema implements Serializable {
    private List<Place> places = new ArrayList<>();

    public Cinema() {
        this.places.add(new Place(1, 1000));
        this.places.add(new Place(2, 500));
        this.places.add(new Place(3, 2000));
        this.places.add(new Place(4, 9000));
    }

    public List<Place> getPlaceList() {
        return places;
    }

    public int getPlacePrice(int number) throws PlaceNotFoundException {
        return getPlacePrice(getSeatByNumber(number));
    }

    private int getPlacePrice(Place place) {
        return place.getPrice();
    }

    public void reservePlace(int number) throws PlaceAlreadyTakenException, PlaceNotFoundException {
        reservePlace(getSeatByNumber(number));
    }

    @Lock
    private void reservePlace(Place place) throws PlaceAlreadyTakenException {
        if (! place.isAvailable()) {
            throw new PlaceAlreadyTakenException(String.format("Place #%d is already taken.", place.getNumber()));
        }

        place.setAvailable(false);
    }

    public Place getSeatByNumber(int number) throws PlaceNotFoundException {
        Place place = places.stream().filter(s -> s.getNumber() == number).findFirst().orElse(null);

        if (place == null) {
            throw new PlaceNotFoundException(String.format("Place with number %d doesn't exist", number));
        }

        return place;
    }
}
