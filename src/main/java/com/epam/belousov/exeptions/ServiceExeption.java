package com.epam.belousov.exeptions;

public class ServiceExeption extends RuntimeException {

    /**
     * Construct a ServiceExeption with exeption message
     *
     * @param message that could be logged and analysed
     */
    public ServiceExeption(String message) {
        super(message);
    }
}
