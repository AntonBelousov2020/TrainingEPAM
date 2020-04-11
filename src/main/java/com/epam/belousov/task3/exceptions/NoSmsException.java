package com.epam.belousov.task3.exceptions;

public class NoSmsException extends RuntimeException {
    public NoSmsException(String message) {
        super(message);
    }
}
