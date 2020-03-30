package com.epam.belousov.structuralpatterns.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class describes Bridge method work
 */
public class BridgeWork {
    Logger log = LoggerFactory.getLogger(BridgeWork.class);

    /**
     * This method realize main logic for Bridge method. This method initializes some remote needed,
     * also call other methods from other classes
     *
     * @param device - some entry device
     */
    public void bridgeWork(Device device) {
        log.info("\n");
        log.info("Bridge");
        log.info("Simple remote");
        SimpleRemote simpleRemote = new SimpleRemote(device);
        simpleRemote.power();
        device.getStatus();

        log.info("Advanced remote");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.getStatus();
    }
}
