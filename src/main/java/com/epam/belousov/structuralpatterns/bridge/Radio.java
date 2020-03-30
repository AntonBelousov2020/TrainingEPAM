package com.epam.belousov.structuralpatterns.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements on interface Device and realize concrete object of the device - radio
 */
public class Radio implements Device {
    Logger log = LoggerFactory.getLogger(Radio.class);

    private boolean on = false;
    private int volume = 15;
    private int channel = 5;

    /**
     * This override method check is enable or not radio
     *
     * @return true, if radio is enabled
     * false, if radio is not enabled
     */
    @Override
    public boolean isEnabled() {
        return on;
    }

    /**
     * This override method enable radio
     */
    @Override
    public void enable() {
        on = true;
    }

    /**
     * This override method disable radio
     */
    @Override
    public void disable() {
        on = false;
    }

    /**
     * This override method get volume on radio
     *
     * @return value of volume
     */
    @Override
    public int getVolume() {
        return volume;
    }

    /**
     * This override method set volume on radio
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
     * This override method get channel on radio
     *
     * @return channel number
     */
    @Override
    public int getChannel() {
        return channel;
    }

    /**
     * This override method set channel number on radio
     *
     * @param channel - value channel number
     */
    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    /**
     * This override method get status radio
     */
    @Override
    public void getStatus() {
        log.info("Radio");
        log.info("Radio is " + (on ? "enabled" : "disabled"));
        log.info("Currant volume is " + volume);
        log.info("Currant channel is " + channel);
        log.info("\n");
    }
}
