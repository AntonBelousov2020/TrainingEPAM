package belousov.logics;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Slf4j
public class MyWriteToFile {

    /**
     * This method write to file some list string
     *
     * @param fileName - file name for writing
     * @param lines    - list some string for write on yhe file
     */
    public static void myWriteToFile(String fileName, List<String> lines) {
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < lines.size() - 1; i++) {
                out.write(lines.get(i) + "\n");
            }

            //For write last string on the file without new line after last string
            out.write(lines.get(lines.size() - 1));
        } catch (Exception e) {
            log.error(e.getMessage());
            System.out.println("Ошибка, при записи в файл. Смотреть в logs\\debug.log");
        }
    }
}
