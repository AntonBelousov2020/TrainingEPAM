package com.epam.belousov.generativepatterns.prototype;

import java.util.Objects;

/**
 * This class is template for subclasses
 */
public abstract class Shape {
    private int x;
    private int y;
    private String color;

    public Shape() {
    }

    public Shape(Shape param) {
        if (param != null) {
            this.x = param.x;
            this.y = param.y;
            this.color = param.color;
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    /**
     * This method is template for some realize on other subclasses
     *
     * @return cloned some object
     */
    public abstract Shape clone();

    /**
     * This overrode method equals for compare two objects
     *
     * @param o - input compared some object with some fields
     * @return true if objects equals
     * false if objects not equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Shape)) return false;
        Shape shape = (Shape) o;
        return getX() == shape.getX() &&
                getY() == shape.getY() &&
                Objects.equals(getColor(), shape.getColor());
    }

    /**
     * This overrode method calculate hash for some object
     *
     * @return hash code object
     */
    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY(), getColor());
    }
}
