package com.epam.belousov.service;

import com.epam.belousov.exceptions.NoValueAnnotationException;
import com.epam.belousov.logic.MainLogic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class describe create object use reflection
 * @param <T> - type of object to create
 */
public class Service<T> {
    Logger log = LoggerFactory.getLogger(Service.class);

    /**
     * This method create exemplar of some class
     * @param clazz - input object class
     * @return Collection of created object
     */
    public List<T> getExemplarObject(Class<?> clazz) {
        List<T> listCreatedObject = new ArrayList<>();
        if (MainLogic.checkAnnotationEntity(clazz)) {
            try {
                MainLogic.fillFieldAnnotation(clazz);
                try {
                    listCreatedObject = (List<T>) MainLogic.fillInEntityFieldsWithValuesByValueAnnotation(clazz);
                    return listCreatedObject;
                } catch (Exception e) {
                    log.error(e.getMessage());
                }
            } catch (NoValueAnnotationException e) {
                log.error(e.toString());
            } catch (IOException e) {
                log.error(e.toString());
            } catch (NumberFormatException e) {
                log.error(e.toString());
            }
        } else {
            try {
                MainLogic.checkIllegalStateException(clazz);
            } catch (IllegalStateException e) {
                log.error(e.toString());
            }
        }
        return listCreatedObject;
    }
}

