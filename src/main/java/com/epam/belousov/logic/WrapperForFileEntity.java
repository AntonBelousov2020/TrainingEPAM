package com.epam.belousov.logic;

/**
 * This class describe wrapper for entity parameter
 */
public class WrapperForFileEntity {

    private String name;
    private int age;

    public WrapperForFileEntity(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
