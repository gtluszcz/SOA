package com.gtluszcz.ejb.implementation.Exceptions;

import javax.ejb.ApplicationException;
import java.io.Serializable;

@ApplicationException
public class PlaceAlreadyTakenException extends Exception implements Serializable {
    public PlaceAlreadyTakenException(String message) {
        super(message);
    }
}
