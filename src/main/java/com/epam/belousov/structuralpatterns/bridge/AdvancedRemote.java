package com.epam.belousov.structuralpatterns.bridge;

/**
 * This class implements on interface Remote and realize concrete object of the remote - advanced remote
 */
public class AdvancedRemote extends SimpleRemote {
    public AdvancedRemote(Device device) {
        super.device = device;
    }

    /**
     * This method set volume 0. Silent mode
     */
    public void mute() {
        log.info("Remote: mute");
        device.setVolume(0);
    }
}
