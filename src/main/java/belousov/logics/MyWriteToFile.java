package belousov.logics;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

@Slf4j
public class MyWriteToFile {

    public static void myWriteToFile(String fileName, List<String> lines){
        try (BufferedWriter out = new BufferedWriter(new FileWriter(fileName, false))) {
            for (int i = 0; i < lines.size()-1; i++) {
                out.write(lines.get(i) + "\n");
            }

            //Для записи последней строки в файл без переноса строки
            out.write(lines.get(lines.size()-1));
        } catch (Exception e){
            log.error(e.getMessage());
            System.out.println("Ошибка, при записи в файл. Смотреть в logs\\debug.log");
        }
    }
}
