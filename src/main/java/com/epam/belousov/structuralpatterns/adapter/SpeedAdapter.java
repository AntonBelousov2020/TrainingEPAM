package com.epam.belousov.structuralpatterns.adapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class is adapter (kilometers per hour)
 */
public class SpeedAdapter {
    private static final float KM_H_IN_MIL_H = 1.61F;
    Logger log = LoggerFactory.getLogger(SpeedAdapter.class);

    private Speed speed;

    /**
     * Construct get initialized current speed on km/h
     */
    public SpeedAdapter(float initialSpeed) {
        log.info("\n");
        this.speed = new Speed(convertKmInHourToMilInH(initialSpeed));
        log.info("Current speed is " + initialSpeed + " km/h");
    }

    /**
     * This method increase speed value on km/h
     *
     * @return increase speed
     */
    public float speedIncreaseK() {
        float increase = 0.0F;
        increase += 10.0F;
        return increase;
    }

    /**
     * This method reduction speed value on km/h
     *
     * @return reduction speed
     */
    public float speedReductionK() {
        float reduction = 0.0F;
        reduction -= 10.0F;
        return reduction;
    }

    /**
     * Change current speed by some value on km/h
     *
     * @param changeSpeed - value for change speed
     */
    public void changeSpeedK(float changeSpeed) {
        speed.changeSpeed(convertKmInHourToMilInH(changeSpeed));
        log.info("Now current speed is changing by " + changeSpeed + " km/h");
    }

    /**
     * This method convert km/h on m/h
     *
     * @param kmInH - input value km/h
     * @return value m/h
     */
    private float convertKmInHourToMilInH(float kmInH) {
        return kmInH / KM_H_IN_MIL_H;
    }

    /**
     * This method convert m/h on km/h
     *
     * @param milInH - input value m/h
     * @return value km/h
     */
    private float convertMilInHourToKmInH(float milInH) {
        return milInH * KM_H_IN_MIL_H;
    }

    /**
     * This method returned current speed in k/h
     *
     * @return current speed on k/h
     */
    public float getCurrentSpeedK() {
        float currentSpeedK = convertMilInHourToKmInH(speed.getCurrentSpeed());
        log.info("Current speed is " + currentSpeedK + " km/h");
        log.info("Current speed is " + speed.getCurrentSpeed() + " m/h");
        return currentSpeedK;
    }
}
