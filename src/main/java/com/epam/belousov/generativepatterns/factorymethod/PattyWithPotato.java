package com.epam.belousov.generativepatterns.factorymethod;

/**
 * This class implements on interface Patty and realize concrete object of the patty
 */
public class PattyWithPotato implements Patty {

    public PattyWithPotato() {
    }

    /**
     * This method create patty with potato
     *
     * @return string with patty
     */
    @Override
    public String patty() {
        return "Patty with potato cooked";
    }
}
