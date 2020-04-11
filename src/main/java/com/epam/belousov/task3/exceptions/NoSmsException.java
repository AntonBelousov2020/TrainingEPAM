package com.epam.belousov.task3.exceptions;

/**
 * This class created my wrapper for exception with have not new message for read to writer
 */
public class NoSmsException extends RuntimeException {

    /**
     * This constructor use constructor by supper class
     * @param message - input message
     */
    public NoSmsException(String message) {
        super(message);
    }
}
