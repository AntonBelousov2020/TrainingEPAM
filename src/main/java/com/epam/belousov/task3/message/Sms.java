package com.epam.belousov.task3.message;

/**
 * This class describe sms entity
 */
public class Sms {
    private String message;

    public Sms() {

    }

    public Sms(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SMS contains: " + message;
    }
}
