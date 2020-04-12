package com.epam.belousov.task3.exceptions;

/**
 * This class created my wrapper for exception with have not free memory for new message
 */
public class NoMemoryException extends RuntimeException {

    /**
     * This constructor use constructor by supper class
     * @param message - input message
     */
    public NoMemoryException(String message) {
        super(message);
    }
}
