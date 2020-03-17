package belousov.logics;

import java.util.List;

public class MyPrintToCommandLine {

    public static void printToCommandline (String fileName){

        List<String> lines = MyReadFromFile.parseFile(fileName);

        for (String lineCount : lines) {
            System.out.println(lines);
        }
    }

    public static void printToCommandlineToLine(String fileName, int numberLine){

        List<String> lines = MyReadFromFile.parseFile(fileName);

        System.out.println(lines.get(numberLine - 1));
    }
}
