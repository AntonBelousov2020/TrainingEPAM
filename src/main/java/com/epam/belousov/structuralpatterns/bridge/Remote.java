package com.epam.belousov.structuralpatterns.bridge;

/**
 * This interface construct template for concrete object
 */
public interface Remote {
    /**
     * This method enable or disable some device use some remote
     */
    public void power();

    /**
     * This method reduces volume on some device use some remote
     */
    public void volumeDown();

    /**
     * This method raises volume on some device use some remote
     */
    public void volumeUp();

    /**
     * This method change channel by reduces on some device use some remote
     */
    public void channelDown();

    /**
     * This method change channel by raises on some device use some remote
     */
    public void channelUp();
}
