package epamTraining.generics;

import java.lang.*;
import epamTraining.generics.Human;

public class GenericsWork {

    public void genericsWork(){
        Human human = new Human("Миша", 1999, 2, 29, "Юбилейная", 7, 8, 32);
        System.out.println(human.toStringH());
    }
}
