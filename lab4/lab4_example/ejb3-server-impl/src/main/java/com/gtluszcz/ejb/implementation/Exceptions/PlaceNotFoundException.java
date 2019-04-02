package com.gtluszcz.ejb.implementation.Exceptions;

import javax.ejb.ApplicationException;
import java.io.Serializable;

@ApplicationException
public class PlaceNotFoundException extends Exception implements Serializable {
    public PlaceNotFoundException(String message) {
        super(message);
    }
}
