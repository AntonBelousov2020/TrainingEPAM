package belousov.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class Memory {

    /**
     * This method try to get OutOfMemoryError
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        try {
            for (int i = 0; ; i++) {
                list.add("Cat");
                System.out.println(i);
            }
        } catch (OutOfMemoryError e) {
            log.error("Ошибка " + e.toString());
            System.exit(-1);
        }
    }
}
