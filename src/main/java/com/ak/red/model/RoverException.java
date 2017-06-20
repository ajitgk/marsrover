package com.ak.red.model;

/**
 * Created by ak on 20/06/2017.
 */
public class RoverException extends Throwable {

    public RoverException(String message) {
        super(message);
    }

    public RoverException(String message, Throwable cause) {
        super(message, cause);
    }

}
