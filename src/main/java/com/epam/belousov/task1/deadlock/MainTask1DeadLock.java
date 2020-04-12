package com.epam.belousov.task1.deadlock;

/**
 * This class is entry point for start program, this class also create object by DeadLockDemo1 class
 * and object by DeadLockDemo2 class. Also this class call methods by DeadLockDemo1 and DeadLockDemo2 classes
 */
class MainTask1DeadLock extends Thread {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        DeadLockDemo1 deadLock1 = new DeadLockDemo1();
        DeadLockDemo2 deadLock2 = new DeadLockDemo2();

        deadLock1.start();
        deadLock2.start();
    }
}
