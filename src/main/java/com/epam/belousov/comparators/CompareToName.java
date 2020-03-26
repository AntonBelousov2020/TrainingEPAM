package com.epam.belousov.comparators;

import com.epam.belousov.human.Human;

import java.util.Comparator;

public class CompareToName implements Comparator<Human> {
    /**
     * This override method for compare fields firstName, secondName and patronymic in Human class
     *
     * @param human - first entry parameter, exemplar Human class
     * @param t1    - second entry parameter, exemplar Human class
     * @return - 1 or 0, or 1
     * 0 if human firstName, secondName and patronymic is equal to t1 firstName, secondName and patronymic
     * -1 if human firstName, secondName and patronymic smaller then t1 firstName, secondName and patronymic,
     * 1 if human firstName, secondName and patronymic lager then t1 firstName, secondName and patronymic
     */
    @Override
    public int compare(Human human, Human t1) {
        if (human.getFirstName().compareTo(t1.getFirstName()) != 0)
            return human.getFirstName().compareTo(t1.getFirstName());
        else if (human.getSecondName().compareTo(t1.getSecondName()) != 0)
            return human.getSecondName().compareTo(t1.getSecondName());
        else return human.getPatronymic().compareTo(t1.getPatronymic());
    }
}
