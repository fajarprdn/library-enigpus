package com.enigma.enigpusboot.exception;

import org.hibernate.service.spi.ServiceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.rmi.ServerException;

@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class InsufficientStockException extends ServiceException {
    public InsufficientStockException(String message) {
        super(message);
    }
}
