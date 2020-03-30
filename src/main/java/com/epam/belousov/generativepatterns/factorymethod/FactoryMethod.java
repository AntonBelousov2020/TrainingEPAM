package com.epam.belousov.generativepatterns.factorymethod;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class describes Factory method work
 */
public class FactoryMethod {
    private static final Logger log = LoggerFactory.getLogger(FactoryMethod.class);
    private static Recipe recipe;

    /**
     * This method realize main logic for factory method. This method initializes some recipe needed,
     * also check input parameter equals null or not
     */
    public void configure() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src\\main\\resources\\typePatty.txt"));

            String str = bufferedReader.readLine();
            log.info("\nNew order");
            log.info("Read order. Order is: \n" + str);

            if (str != null) {
                switch (str) {
                    case "patty with potato":
                        recipe = new RecipePattyWithPotato();
                        break;
                    case "patty with meat":
                        recipe = new RecipePattyWithMeat();
                        break;
                    default:
                        log.error("Invalid type patty on the order");
                        log.error("Application completed execution");
                        System.exit(0);
                }
            } else {
                throw new NullPointerException();
            }
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            log.error("Order is empty");
            System.exit(0);
        }
    }

    /**
     * This method make new patty
     */
    public void createPatty() {
        log.info(recipe.createRecipe().patty());
    }
}
