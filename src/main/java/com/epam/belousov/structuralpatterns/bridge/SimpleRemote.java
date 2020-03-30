package com.epam.belousov.structuralpatterns.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class implements on interface Remote and realize concrete object of the remote - simple remote
 */
public class SimpleRemote implements Remote {
    Logger log = LoggerFactory.getLogger(SimpleRemote.class);

    protected Device device;

    public SimpleRemote() {
    }

    public SimpleRemote(Device device) {
        this.device = device;
    }

    /**
     * This override method enable or disable some device use simple remote
     */
    @Override
    public void power() {
        log.info("Remote: power toggle");

        if (device.isEnabled()) {
            device.disable();
        } else {
            device.enable();
        }
    }

    /**
     * This override method reduces volume on some device use simple remote
     */
    @Override
    public void volumeDown() {
        log.info("Remote: volume down");
        device.setVolume(device.getVolume() - 5);
    }

    /**
     * This override method raises volume on some device use simple remote
     */
    @Override
    public void volumeUp() {
        log.info("Remote: volume up");
        device.setVolume(device.getVolume() + 5);
    }

    /**
     * This override method change channel by reduces on some device use simple remote
     */
    @Override
    public void channelDown() {
        log.info("Remote: channel down");
        device.setChannel(device.getChannel() - 1);
    }

    /**
     * This method change channel by raises on some device use simple remote
     */
    @Override
    public void channelUp() {
        log.info("Remote: channel up");
        device.setChannel(device.getChannel() + 1);
    }
}
