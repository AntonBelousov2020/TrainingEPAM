package com.epam.belousov.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class handle information from file
 */
public class WorkWithFile {
    /**
     * This method read text from the file
     *
     * @param pathToFile - input path to file
     * @return list string rode from the file
     * @throws IOException
     */
    public static List<String> fileReader(String pathToFile) throws IOException {
        List<String> stingsInFile = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile));
        String currentString;
        while ((currentString = bufferedReader.readLine()) != null) {
            stingsInFile.add(currentString);
        }
        return stingsInFile;
    }

    /**
     * This method check valid input parameters
     *
     * @param age  - input parameter age
     * @param name - input parameter name
     * @return true, if input parameters is correct
     * IllegalArgumentException, if input parameters isn't correct
     */
    public static boolean paramIsValid(String age, String name) {
        if (age.matches("age=.+") && name.matches("name=.+")) {
            return true;
        }
        throw new IllegalArgumentException("Incorrect input parameters from file");
    }

    /**
     * This method get lines form the file, check parameters to valid, handle it
     *
     * @param strings - list of lines from the file
     * @return list of parameters wrapped into WrapperForFileEntity
     */
    public static List<WrapperForFileEntity> parseInputFile(List<String> strings) {
        List<WrapperForFileEntity> parsedLine = new ArrayList<>();
        for (int i = 0; i < strings.size(); i++) {
            String inputAge = strings.get(i++);
            String inputName = strings.get(i++);
            if (paramIsValid(inputAge, inputName)) {
                String age = inputAge.split("=")[1];
                String name = inputName.split("=")[1];
                parsedLine.add(new WrapperForFileEntity(name, Integer.parseInt(age)));
            }
        }
        return parsedLine;
    }
}
