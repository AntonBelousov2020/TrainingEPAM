package com.epam.belousov.task2.raceconditionsolution;

/**
 * This class describe logic for solution race condition
 */
public class RaceCondition extends Calc {

    /**
     * This method create some threads for demonstration race condition solution
     */
    public void workRaceConditionSolution() {
        synchronized (this) {
            Thread thread1 = new Thread(this::raceCondition);
            Thread thread2 = new Thread(this::lowCondition);
            thread1.start();
            thread2.start();
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
