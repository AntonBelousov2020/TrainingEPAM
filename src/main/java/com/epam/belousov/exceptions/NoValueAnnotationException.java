package com.epam.belousov.exceptions;

/**
 * This class description, when value annotation isn't exist
 */
public class NoValueAnnotationException extends RuntimeException {
    public NoValueAnnotationException(String message) {
        super(message);
    }
}
