package com.epam.belousov.task1.racecondition;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class realize logic for shared counter. This class creates base for make race condition
 */
public class Calc {
    private static final Logger log = LoggerFactory.getLogger(RaceCondition.class);
    private int concurVar = 0;

    /**
     * This method increment shared variable
     */
    protected void inc() {
        concurVar += 1;
    }

    /**
     * This method decrement shared variable
     */
    protected void dec() {
        concurVar -= 1;
    }

    /**
     * This method print value shared variable
     */
    public void print() {
        log.info("concurVar= {}", concurVar);
    }
}
