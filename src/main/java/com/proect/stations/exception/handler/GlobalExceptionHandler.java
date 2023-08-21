package com.proect.stations.exception.handler;

import com.google.gson.JsonParseException;
import com.proect.stations.dto.response.ResponseDTO;
import com.proect.stations.exception.ApiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<Object> handleApiExceptions(ApiException exception) {
        return ResponseEntity.status(exception.getStatus())
                .body(
                        ResponseDTO
                                .builder()
                                .status(exception.getStatus().value())
                                .message(exception.getMessage())
                                .content(null)
                                .build()
                );
    }

    @ExceptionHandler({JsonParseException.class})
    public ResponseEntity<Object> handleJsonExceptions(JsonParseException jsonParseException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(
                        ResponseDTO
                                .builder()
                                .status(HttpStatus.BAD_REQUEST.value())
                                .message(jsonParseException.getMessage())
                                .content(null)
                                .build()
                );
    }
}