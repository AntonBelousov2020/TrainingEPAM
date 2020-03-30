package com.epam.belousov.structuralpatterns.bridge;

/**
 * This interface construct template for concrete object
 */
public interface Device {
    /**
     * This method check is enable or not some device
     *
     * @return true, if device is enabled
     * false, if device is not enabled
     */
    public boolean isEnabled();

    /**
     * This method enable some device
     */
    public void enable();

    /**
     * This method disable some device
     */
    public void disable();

    /**
     * This method get volume on some device
     *
     * @return value of volume
     */
    public int getVolume();

    /**
     * This method set volume on some device
     *
     * @param volume - entry value of volume
     */
    public void setVolume(int volume);

    /**
     * This method get channel on some device
     *
     * @return channel number
     */
    public int getChannel();

    /**
     * This method set channel number on some device
     *
     * @param channel - value channel number
     */
    public void setChannel(int channel);

    /**
     * This method get status some device
     */
    public void getStatus();
}
