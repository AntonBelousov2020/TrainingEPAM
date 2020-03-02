package Belousov;

import java.lang.*;
import Belousov.Human;

public class GenericWork {

        public static void main(String[] args){
            Human human = new Human("Миша", 1999, 2, 29, "Юбилейная", 7, 8, 32);
            System.out.println(human.toStringH());
        }

}
