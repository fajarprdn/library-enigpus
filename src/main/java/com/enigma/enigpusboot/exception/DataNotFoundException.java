package com.enigma.enigpusboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.rmi.ServerException;

@ResponseStatus (HttpStatus.INTERNAL_SERVER_ERROR)
public class DataNotFoundException extends ServerException {
    public DataNotFoundException(String message) {
        super(message);
    }
}
