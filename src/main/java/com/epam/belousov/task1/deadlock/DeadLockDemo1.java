package com.epam.belousov.task1.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class describe work for thread 1
 */
public class DeadLockDemo1 extends MainTask1DeadLock {
    private static final Logger log = LoggerFactory.getLogger(DeadLockDemo1.class);

    /**
     * This method slept first thread and synchronized it with second thead
     */
    public void deadLockStart1() {
        synchronized (lock1) {
            log.info("Thread 1: holding lock1...");

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            log.info("Thead 1: waiting for lock2...");

            synchronized (lock2) {
                log.info("Thread 1: holding lock 1 & 2...");
            }
        }
    }
}
