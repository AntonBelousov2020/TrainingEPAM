package com.epam.belousov.generativepatterns.factorymethod;

/**
 * This class implements on interface Patty and realize concrete object of the patty
 */
public class PattyWithMeat implements Patty {

    public PattyWithMeat() {
    }

    /**
     * This method create patty with meat
     *
     * @return String with patty
     */
    @Override
    public String patty() {
        return "Patty with meat cooked";
    }
}
