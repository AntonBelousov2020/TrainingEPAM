package com.epam.belousov.task2.deadlocksolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class describe work for thread 2
 */
class DeadLockDemo2 extends MainTask2DeadLockSolution {
    private static final Logger log = LoggerFactory.getLogger(DeadLockDemo2.class);

    /**
     * This method slept first thread and synchronized it with second thead
     */
    @Override
    public void run() {
        synchronized (lock1) {
            log.info("Thread2: has lock1...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            log.info("Thread2: waiting for lock2...");

            synchronized (lock2) {
                log.info("Thread2: no deadlock...");
            }
        }
    }
}
