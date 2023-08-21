package com.proect.stations.exception;

import org.springframework.http.HttpStatus;

public class StationNotFoundException extends ApiException {

    public StationNotFoundException() {
        super(HttpStatus.NOT_FOUND, "Cannot found station!");
    }

    public StationNotFoundException(HttpStatus status, String message) {
        super(status, message);
    }
}
