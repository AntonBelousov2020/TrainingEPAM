package com.epam.belousov;

import com.epam.belousov.workwithdb.WorkWithDb;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Belousov Anton
 * @{code Main} class describe work with JDBC
 * In this class also call methods by some other class.
 */
public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    /**
     * This method is entry point for start program
     *
     * @param args - input arguments. Not used
     */
    public static void main(String[] args) {
        WorkWithDb workWithDb = new WorkWithDb();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;


        while (!flag) {
            log.info("Options:\n" +
                    "0 - Exit\n" +
                    "1 - Show all rows from product table\n" +
                    "2 - Search row by title\n" +
                    "3 - Update field title\n" +
                    "4 - Delete record\n" +
                    "5 - Add new record");
            try {
                switch (scanner.nextInt()) {
                    case 0:
                        flag = true;
                    case 1:
                        workWithDb.getAllRecords();
                        break;
                    case 2:
                        workWithDb.findByTitle();
                        break;
                    case 3:
                        workWithDb.updateRecords();
                        break;
                    case 4:
                        workWithDb.deleteRecord();
                        break;
                    case 5:
                        workWithDb.addRecord();
                        break;
                }
            } catch (InputMismatchException e) {
                log.error(e.getMessage());
                flag = true;
            }
        }
        workWithDb.closeConnection();
    }
}
