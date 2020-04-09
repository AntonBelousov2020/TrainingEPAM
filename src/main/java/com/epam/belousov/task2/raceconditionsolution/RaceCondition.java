package com.epam.belousov.task2.raceconditionsolution;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class describe logic for solution race condition
 */
class RaceCondition extends Calc {
    private static final Logger log = LoggerFactory.getLogger(RaceCondition.class);

    /**
     * This method create some threads for demonstration race condition solution
     */
    public void workRaceConditionSolution() {
        synchronized (this) {
            try {
                Thread thread1 = new Thread(this::raceCondition);
                Thread thread2 = new Thread(this::lowCondition);
                thread1.start();
                thread2.sleep(1000);
                thread2.start();
            } catch (InterruptedException e) {
                log.error(e.getMessage());
            }
        }
    }

    /**
     * This method make a increment for shared variable and print value this variable in loop
     */
    private void raceCondition() {
        for (int i = 0; i < 10; i++) {
            inc();
            print();
        }
    }

    /**
     * This method make a decrement for shared variable and print value this variable in loop
     */
    private void lowCondition() {
        for (int i = 0; i < 10; i++) {
            dec();
            print();
        }
    }
}
