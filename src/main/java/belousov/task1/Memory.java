package belousov.task1;

import java.util.ArrayList;
import java.util.List;

public class Memory {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; ; i++) {
            list.add("Cat");
            System.out.println(i);
        }
    }
}
