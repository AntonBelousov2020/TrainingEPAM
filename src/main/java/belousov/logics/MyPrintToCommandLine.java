package belousov.logics;

import java.util.List;

public class MyPrintToCommandLine {

    /**
     * This method pints text on commandline from a file
     *
     * @param fileName - file name
     */
    public static void printToCommandline(String fileName) {

        List<String> lines = MyReadFromFile.parseFile(fileName);

        for (String lineCount : lines) {
            System.out.println(lines);
        }
    }

    /**
     * This method prints line text on commandline from a file
     *
     * @param fileName   - file name
     * @param numberLine - number line for print from a file
     */
    public static void printToCommandlineToLine(String fileName, int numberLine) {

        List<String> lines = MyReadFromFile.parseFile(fileName);

        System.out.println(lines.get(numberLine - 1));
    }
}
