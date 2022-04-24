package com.enigma.enigpusboot.exception;

import java.rmi.ServerException;

public class MemberIsBlockedException extends ServerException {
    public MemberIsBlockedException(String message) {
        super(message);
    }
}
