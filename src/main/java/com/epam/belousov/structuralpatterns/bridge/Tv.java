package com.epam.belousov.structuralpatterns.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements on interface Device and realize concrete object of the device - TV
 */
public class Tv implements Device {
    Logger log = LoggerFactory.getLogger(Tv.class);

    private boolean on = false;
    private int volume = 15;
    private int channel = 5;

    /**
     * This override method check is enable or not TV
     *
     * @return true, if TV is enabled
     * false, if TV is not enabled
     */
    @Override
    public boolean isEnabled() {
        return on;
    }

    /**
     * This override method enable TV
     */
    @Override
    public void enable() {
        on = true;
    }

    /**
     * This override method disable TV
     */
    @Override
    public void disable() {
        on = false;
    }

    /**
     * This override method get volume on TV
     *
     * @return value of volume
     */
    @Override
    public int getVolume() {
        return volume;
    }

    /**
     * This override method set volume on TV
     *
     * @param volume - entry value of volume
     */
    @Override
    public void setVolume(int volume) {
        if (volume > 100) {
            this.volume = 100;
        } else if (volume < 0) {
            this.volume = 0;
        } else {
            this.volume = volume;
        }
    }

    /**
     * This override method get channel on TV
     *
     * @return channel number
     */
    @Override
    public int getChannel() {
        return channel;
    }

    /**
     * This override method set channel number on TV
     *
     * @param channel - value channel number
     */
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * This override method get status TV
     */
    @Override
    public void getStatus() {
        log.info("TV");
        log.info("TV is " + (on ? "enabled" : "disabled"));
        log.info("Current volume is " + volume);
        log.info("Currant channel is " + channel);
        log.info("\n");
    }
}
