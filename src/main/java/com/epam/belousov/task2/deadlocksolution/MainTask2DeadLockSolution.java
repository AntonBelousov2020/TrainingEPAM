package com.epam.belousov.task2.deadlocksolution;

/**
 * This class is entry point for start program, this class also create object by DeadLockDemo1 class
 * and object by DeadLockDemo2 class. Also this class call methods by DeadLockDemo1 and DeadLockDemo2 classes
 */
class MainTask2DeadLockSolution extends Thread {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo1 deadLock1 = new DeadLockDemo1();
        DeadLockDemo2 deadlock2 = new DeadLockDemo2();

        deadLock1.start();
        deadlock2.start();
    }
}
