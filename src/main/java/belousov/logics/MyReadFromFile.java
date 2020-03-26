package belousov.logics;

import belousov.exeption.CommandExeption;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class MyReadFromFile {

    /**
     * This method parse input file
     *
     * @param fileName - file name input file
     * @return List of lines. This lines is lines text on the input file
     * @throws CommandExeption in case file not exist or not found
     */
    public static List<String> parseFile(String fileName) throws CommandExeption {

        File file = new File(fileName);
        List<String> lines = new ArrayList<>();

        if (file.exists()) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                while (in.ready()) {
                    lines.add(in.readLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("Файл не найден");
                log.error(e.getMessage());
            } catch (Exception e) {
                log.error(e.getMessage());
                System.out.println("Ошибка при чтении файла. Подробнее в logs\\debug.log");
            }
        } else {
            throw new CommandExeption("Файл не существует");
        }
        return lines;
    }
}
