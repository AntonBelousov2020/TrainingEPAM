package com.epam.belousov.task1.racecondition;

/**
 * This class describe logic for race condition
 */
class RaceCondition extends Calc {

    /**
     * This method create some threads for demonstration race condition
     */
    public void workRaceCondition() {
        Thread thread1 = new Thread(this::raceCondition);
        thread1.start();

        Thread thread2 = new Thread(this::lowCondition);
        thread2.start();
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
