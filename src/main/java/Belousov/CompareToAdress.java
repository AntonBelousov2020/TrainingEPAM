package Belousov;

import java.util.Comparator;

public class CompareToAdress implements Comparator<Human> {
    @Override
    public int compare(Human human, Human t1) {
        return human.getAdress().compareTo(t1.getAdress());
    }
}
