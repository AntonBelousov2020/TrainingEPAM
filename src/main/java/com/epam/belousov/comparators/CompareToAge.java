package com.epam.belousov.comparators;

import com.epam.belousov.human.Human;

import java.util.Comparator;

public class CompareToAge implements Comparator<Human> {
    /**
     * This override method for compare field age in Human class
     *
     * @param human - first entry parameter, exemplar Human class
     * @param t1    - second entry parameter, exemplar Human class
     * @return - 1 or 0, or 1. 0 if human age is equal to t1 age,
     * -1 if human age smaller then t1 age,
     * 1 if human age lager then t1 age
     */
    @Override
    public int compare(Human human, Human t1) {
        return human.getAge().compareTo(t1.getAge());
    }
}
