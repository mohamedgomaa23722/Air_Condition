package com.mg.aircondition.exception;

public class CsException extends RuntimeException {

    Exceptions exception;
    public CsException(Exceptions exception) {
        this.exception = exception;
    }
}
