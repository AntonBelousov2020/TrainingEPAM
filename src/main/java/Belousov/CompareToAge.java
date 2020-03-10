package Belousov;

import java.util.Comparator;

public class CompareToAge implements Comparator <Human>{

    @Override
    public int compare(Human human, Human t1) {
        return human.getAge().compareTo(t1.getAge());
    }
}
