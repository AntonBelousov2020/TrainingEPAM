package com.epam.belousov.task1.deadlock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class describe work for thread 2
 */
class DeadLockDemo2 extends MainTask1DeadLock {
    private static final Logger log = LoggerFactory.getLogger(DeadLockDemo2.class);

    /**
     * This method slept second thread and synchronized it with first thead
     */
    @Override
    public void run() {
        synchronized (lock2) {
            log.info("Thread2: has lock2...");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
            log.info("Thread2: waiting for lock1...");

            synchronized (lock1) {
                log.info("Thread2: no deadlock...");
            }
        }
    }
}
