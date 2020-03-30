package com.epam.belousov.structuralpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Service control speed (miles per hour)
 */
public class Speed {
    private static final Logger log = LoggerFactory.getLogger(Speed.class);
    private float currentSpeed = 0.0F;

    public Speed() {

    }

    /**
     * Construct initialize current speed on m/h
     *
     * @param initialSpeed - new speed
     */
    public Speed(float initialSpeed) {
        this.currentSpeed = initialSpeed;
        log.info("Current speed is " + initialSpeed + " m/h");
    }

    public float getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(float currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * This method increase speed value on m/h
     *
     * @return increase speed
     */
    public float speedIncreaseM() {
        float increase = 0.0F;
        increase += 10.0F;
        return increase;
    }

    /**
     * This method reduction speed value on m/h
     *
     * @return reduction speed
     */
    public float speedReductionM() {
        float reduction = 0.0F;
        reduction -= 10.0F;
        return reduction;
    }

    /**
     * Change current speed by some value on m/h
     *
     * @param changeSpeed - value for change speed
     */
    public void changeSpeed(float changeSpeed) {
        currentSpeed += changeSpeed;
        if (changeSpeed != 0) {
            log.info("Now current speed is changing by " + changeSpeed + " m/h");
        } else {
            log.info("Current speed not change");
        }
    }
}
