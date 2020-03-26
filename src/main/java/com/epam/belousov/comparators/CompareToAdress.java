package com.epam.belousov.comparators;

import com.epam.belousov.human.Human;

import java.util.Comparator;

public class CompareToAdress implements Comparator<Human> {
    /**
     * This override method for compare field adress in Human class,
     * adress is instance variable inner class MyAdress into Human class
     *
     * @param human - first entry parameter, exemplar Human class
     * @param t1    - second entry parameter, exemplar Human class
     * @return -1 or 0, or 1. 0 if human adress is equal to t1 adress,
     * -1 if human adress smaller then t1 adress,
     * 1 if human adress lager then t1 adress
     */
    @Override
    public int compare(Human human, Human t1) {
        return human.getAdress().compareTo(t1.getAdress());
    }
}
