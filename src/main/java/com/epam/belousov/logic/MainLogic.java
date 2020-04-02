package com.epam.belousov.logic;

import com.epam.belousov.annotations.Entity;
import com.epam.belousov.annotations.Value;
import com.epam.belousov.exceptions.NoValueAnnotationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class MainLogic {
    //map of annotation
    private static Map<Field, WrapperForAnnotation> fieldWrapperForAnnotationMap = new HashMap<>();
    //number of entities on the input file
    private static int objectCounter;
    private static List<WrapperForFileEntity> entities;
    private static Logger log = LoggerFactory.getLogger(MainLogic.class);

    /**
     * This method check Entity annotation on some class
     *
     * @param clazz - input class for check
     * @return true, if input class has annotation
     * false, if input class hasn't annotation
     */
    public static boolean checkAnnotationEntity(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(Entity.class)) {
            log.error("{} class hasn't Entity annotation", clazz.getName());
            return false;
        } else {
            log.info("Class {} has Entity annotation", clazz.getName());
            return true;
        }
    }

    /**
     * This method fill collection fieldWrapperForAnnotationMap, if all entity fields or setters will have Value annotation
     *
     * @param clazz - input handled class
     * @return true, if all fields have Value annotation
     * false, if not all fields have Value annotation
     * @throws IOException
     */
    public static boolean fillFieldAnnotation(Class<?> clazz) throws IOException {
        fieldWrapperForAnnotationMap.clear();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (!field.isAnnotationPresent(Value.class)) {
                Method method = getAnnotatedSetters(field, clazz);
                Value value = method.getAnnotation(Value.class);
                Parameter parameterSetter = method.getParameters()[0];
                fieldWrapperForAnnotationMap.put(field, getAnnotationWrapper(parameterSetter.getType(), value));
            } else {
                Value value = field.getAnnotation(Value.class);
                fieldWrapperForAnnotationMap.put(field, getAnnotationWrapper(field.getType(), value));
            }
        }
        log.info("All class fields {} have Value annotation", clazz.getName());
        return true;
    }

    /**
     * This method get value from Value annotation and wraps it in a WrapperForAnnotation wrapper
     *
     * @param clazz           - handled entity class
     * @param valueAnnotation - handled annotation
     * @return wrapper WrapperForAnnotation
     * @throws IOException
     */
    private static WrapperForAnnotation getAnnotationWrapper(Class<?> clazz, Value valueAnnotation) throws IOException {
        WrapperForAnnotation wrapperForAnnotation = null;
        if (!valueAnnotation.filePath().isEmpty()) {
            String pathToFile = valueAnnotation.filePath();
            wrapperForAnnotation = new WrapperForAnnotation("filePath", pathToFile);
        } else {
            if (!valueAnnotation.stringValue().equals("some name")) {
                if (clazz == int.class) {
                    int age = Integer.parseInt(valueAnnotation.stringValue());
                    wrapperForAnnotation = new WrapperForAnnotation("intValue", age);
                } else if (clazz == String.class) {
                    wrapperForAnnotation = new WrapperForAnnotation("stringValue", valueAnnotation.stringValue());
                }
            } else if (clazz == int.class) {
                wrapperForAnnotation = new WrapperForAnnotation("intValue", valueAnnotation.intValue());
            } else if (clazz == String.class) {
                wrapperForAnnotation = new WrapperForAnnotation("stringValue", valueAnnotation.stringValue());
            }
        }
        return wrapperForAnnotation;
    }

    /**
     * This method check Value annotation on fields into some class. This class haven't Entity annotation
     *
     * @param clazz - handle class
     * @return true, if fields haven't Value annotation
     * false, if some fields on class have Value annotation
     */
    public static boolean checkIllegalStateException(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class)) {
                throw new IllegalStateException("Field " + field.getName() + " shouldn't have annotation, because" +
                        " this class haven't Entity annotation");
            } else {
                try {
                    if (getAnnotatedSetters(field, clazz) != null) {
                        throw new IllegalStateException("Field " + field.getName() + " shouldn't have annotation," +
                                " because this class haven't Entity annotation");
                    }
                } catch (NoValueAnnotationException e) {
                    log.error(e.getMessage());
                }
            }
        }
        return true;
    }

    /**
     * This method find setters for some field without Value annotation and check setter for annotation
     *
     * @param field - input checked field
     * @param clazz - input handled class
     * @return method, if this method has Value annotation,
     * else this method throws an exception NoValueAnnotationException
     */
    private static Method getAnnotatedSetters(Field field, Class<?> clazz) {
        String fieldName = field.getName();
        String methodName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                if (method.isAnnotationPresent(Value.class)) {
                    return method;
                }
            }
        }
        throw new NoValueAnnotationException("Field " + field.getName() + " hasn't Value annotation");
    }

    /**
     * This method fill in fields entity with Entity annotation by values from Value annotation options
     *
     * @param clazz - input handled entity class
     * @return Collection with filled fields
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws IOException
     */
    public static List<Object> fillInEntityFieldsWithValuesByValueAnnotation(Class<?> clazz) throws NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException, IOException {
        List<Object> resultEntityList = new ArrayList<>();
        Set<Field> fieldsSet = fieldWrapperForAnnotationMap.keySet();
        try {
            initValue();
        } catch (IllegalArgumentException e) {
            log.error(e.toString());
            return resultEntityList;
        } catch (IndexOutOfBoundsException e) {
            log.error("File with parameters filled incorrectly - " + e.getClass().getName());
            return resultEntityList;
        }
        int i = 0;
        if (objectCounter == 0) {
            Object object = clazz.getDeclaredConstructor().newInstance();
            for (Field field : fieldsSet) {
                WrapperForAnnotation wrapperForAnnotation = fieldWrapperForAnnotationMap.get(field);
                field.setAccessible(true);
                field.set(object, wrapperForAnnotation.getValue());
            }
            resultEntityList.add(object);
        } else {
            for (int j = 0; j < objectCounter; j++) {
                Object object = clazz.getDeclaredConstructor().newInstance();
                for (Field field : fieldsSet) {
                    WrapperForAnnotation wrapperForAnnotation = fieldWrapperForAnnotationMap.get(field);
                    field.setAccessible(true);
                    if (wrapperForAnnotation.getName().equals("filePath")) {
                        Object value = null;
                        if (field.getType() == String.class) {
                            value = entities.get(j).getName();
                        } else if (field.getType() == int.class) {
                            value = entities.get(j).getAge();
                        }
                        field.set(object, value);
                    } else {
                        field.set(object, wrapperForAnnotation.getValue());
                    }
                }
                resultEntityList.add(object);
            }
        }
        return resultEntityList;
    }

    /**
     * This method parse input file, initialize list entities included list of objects from the input file
     *
     * @throws IOException
     */
    private static void initValue() throws IOException {
        objectCounter = 0;
        entities = null;
        Collection<WrapperForAnnotation> values = fieldWrapperForAnnotationMap.values();
        for (WrapperForAnnotation wrapperForAnnotation : values) {
            if (wrapperForAnnotation.getName() != null && wrapperForAnnotation.getName().equals("pathToFile")) {
                List<String> strings = WorkWithFile.fileReader(wrapperForAnnotation.getValue().toString());
                entities = WorkWithFile.parseInputFile(strings);
                objectCounter = entities.size();
            }
        }
    }
}
