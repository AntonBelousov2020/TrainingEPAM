package com.epam.belousov.pojo;

/**
 * This pojo class. This class describe cat entity. Class without annotation
 */
public class Cat {

    private String name;
    private String colouration;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColouration() {
        return colouration;
    }

    public void setColouration(String colouration) {
        this.colouration = colouration;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
