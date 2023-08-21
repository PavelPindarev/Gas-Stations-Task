package com.proect.stations.exception;

import org.springframework.http.HttpStatus;

public class InvalidFuelTypeException extends ApiException {

    public InvalidFuelTypeException() {
        super(HttpStatus.BAD_REQUEST, "Invalid Fuel Type!");
    }

    public InvalidFuelTypeException(HttpStatus status, String message) {
        super(status, message);
    }
}
