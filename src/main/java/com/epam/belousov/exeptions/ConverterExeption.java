package com.epam.belousov.exeptions;

public class ConverterExeption extends Exception {

    /**
     * Construct a ConverterExeption with exeption message
     *
     * @param message that could be logged and analysed
     */
    public ConverterExeption(String message) {
        super(message);
    }
}
