package com.epam.belousov.workwithdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Belousov Anton
 * @{code WorkWithDb} class describe work with DB using java
 */
public class WorkWithDb {
    private static final Logger log = LoggerFactory.getLogger(WorkWithDb.class);
    private Connection connection = null;
    private Scanner scanner;

    /**
     * This constructor getting connection by DB
     */
    public WorkWithDb() {
        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/dell_store",
                    "postgres",
                    "123");
            log.info("Connection successfully");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
        scanner = new Scanner(System.in);
    }

    /**
     * This method close connection with DB
     */
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method show all records in products table
     */
    public void getAllRecords() {
        try {
            PreparedStatement getAllRecords = connection.prepareStatement("select * from products;");
            ResultSet resultSet = getAllRecords.executeQuery();
            printRecords(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method search some title in product table
     */
    public void findByTitle() {
        log.info("Search by title\nEnter title");
        String title = scanner.nextLine();

        try {
            PreparedStatement findByTitle = connection.prepareStatement("select * from products where title like ?;");
            findByTitle.setString(1, title);
            ResultSet resultSet = findByTitle.executeQuery();
            printRecords(resultSet);
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method update column title use id
     */
    public void updateRecords() {
        log.info("Enter id to update title");

        int id = scanner.nextInt();

        scanner.nextLine();

        log.info("Enter new field title");
        String title = scanner.nextLine();
        try {
            PreparedStatement updateTitle = connection.prepareStatement("update products set title = ? where prod_id = ?;");
            updateTitle.setString(1, title);
            updateTitle.setInt(2, id);
            updateTitle.execute();
            log.info("Update successfully");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method deleted some record use id
     */
    public void deleteRecord() {
        log.info("Enter id for delete record");
        int id = scanner.nextInt();
        try {
            PreparedStatement deleteRecord = connection.prepareStatement("delete from products where prod_id = ?;");
            deleteRecord.setInt(1, id);
            deleteRecord.execute();
            log.info("Record delete successfully");
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method add a new record to products table
     */
    public void addRecord() {
        try {
            PreparedStatement addRecord = connection.prepareStatement("insert into products(category, title, actor," +
                    "price, special, common_prod_id)" +
                    "values(?, ?, ?, ?, ?, ?);");

            log.info("Enter category");
            int category = Integer.parseInt(scanner.nextLine());

            log.info("Enter title");
            String title = scanner.nextLine();

            log.info("Enter actor");
            String actor = scanner.nextLine();

            log.info("Enter price");
            int price = Integer.parseInt(scanner.nextLine());

            log.info("Enter special");
            int special = Integer.parseInt(scanner.nextLine());

            log.info("Enter common_prod_id");
            int common_prod_id = Integer.parseInt(scanner.nextLine());

            addRecord.setInt(1, category);
            addRecord.setString(2, title);
            addRecord.setString(3, actor);
            addRecord.setInt(4, price);
            addRecord.setInt(5, special);
            addRecord.setInt(6, common_prod_id);
            addRecord.execute();

            log.info("Record insert successfully");
        } catch (SQLException | NumberFormatException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * This method print result
     *
     * @param resultSet - result got by DB
     */
    private void printRecords(ResultSet resultSet) {
        try {
            if (!resultSet.next()) {
                log.info("No fount rows");
            } else {
                while (resultSet.next()) {
                    log.info(String.format("%-7d|%-8d|%-19s|%-19s|%-7.2f|%-7d|%d",
                            resultSet.getInt("prod_id"),
                            resultSet.getInt("category"),
                            resultSet.getString("title"),
                            resultSet.getString("actor"),
                            resultSet.getBigDecimal("price"),
                            resultSet.getShort("special"),
                            resultSet.getInt("common_prod_id")));
                }
            }
        } catch (SQLException e) {
            log.error(e.getMessage());
        }
    }
}
