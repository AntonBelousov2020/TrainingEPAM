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
                Thread thread1 = new Thread(this::raceCondition);
                Thread thread2 = new Thread(this::lowCondition);
                thread1.start();
                thread2.start();
    }

    /**
     * This method make a increment for shared variable and print value this variable in loop
     */
    private void raceCondition() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                inc();
                print();
            }
        }
    }

    /**
     * This method make a decrement for shared variable and print value this variable in loop
     */
    private void lowCondition() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                dec();
                print();
            }
        }
    }
}
