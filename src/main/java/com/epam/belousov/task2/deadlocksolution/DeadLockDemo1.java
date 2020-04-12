package com.epam.belousov.task2.deadlocksolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class describe work for thread 1
 */
class DeadLockDemo1 extends MainTask2DeadLockSolution {
    private static final Logger log = LoggerFactory.getLogger(DeadLockDemo1.class);

    /**
     * This method slept first thread and synchronized it with second thead
     */
    @Override
    public void run() {
        synchronized (lock1) {
            log.info("Thread 1: has lock1...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            log.info("Thead 1: waiting for lock2...");

            synchronized (lock2) {
                log.info("Thread 1: no deadlock");
            }
        }
    }
}
