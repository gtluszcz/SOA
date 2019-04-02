package com.gtluszcz.ejb.implementation.Exceptions;

import javax.ejb.ApplicationException;
import java.io.Serializable;

@ApplicationException
public class NotEnoughMoneyException extends Exception implements Serializable {
    public NotEnoughMoneyException(String message) {
        super(message);
    }
}
