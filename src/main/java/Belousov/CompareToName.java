package Belousov;

import java.util.Comparator;

public class CompareToName implements Comparator <Human>{
    @Override
    public int compare(Human human, Human t1) {
        if (human.getFirstName().compareTo(t1.getFirstName()) != 0) return human.getFirstName().compareTo(t1.getFirstName());
        else if (human.getSecondName().compareTo(t1.getSecondName()) != 0) return human.getSecondName().compareTo(t1.getSecondName());
        else return human.getPatronymic().compareTo(t1.getPatronymic());
    }
}
