package com.epam.belousov.structuralpatterns.adapter;

/**
 * This class describes Adapter work
 */
public class AdapterWork {
    public void adapterWork() {
        SpeedAdapter speedAdapter = new SpeedAdapter(60);
        float speedK = speedAdapter.speedIncreaseK();
        speedAdapter.changeSpeedK(speedK);
        speedAdapter.getCurrentSpeedK();
    }
}
