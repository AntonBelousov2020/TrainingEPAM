package com.epam.belousov.pojo;

import com.epam.belousov.annotations.Entity;
import com.epam.belousov.annotations.Value;

/**
 * This pojo class. This class describe human entity. Class with annotation Entity for class,
 * and annotation Value for fields and methods
 */

@Entity
public class Human {

    private int age;

    @Value(filePath = "ListValue.txt")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Value(stringValue = "21", filePath = "ListValue.txt")
    public void setAge(int age) {
        this.age = age;
    }
}
