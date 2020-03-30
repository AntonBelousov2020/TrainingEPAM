package com.epam.belousov.generativepatterns.prototype;

import java.util.Objects;

/**
 * This class extends on Shape abstract class and realize concrete exemplar shape - rectangle
 */
public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle() {
    }

    public Rectangle(Rectangle param) {
        super(param);

        if (param != null) {
            this.width = param.width;
            this.height = param.height;
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * This overrode method clone some rectangle
     *
     * @return cloned concrete rectangle
     */
    @Override
    public Shape clone() {
        return new Rectangle(this);
    }

    /**
     * This overrode method equals for compare two exemplar rectangle
     *
     * @param o - input compared some rectangle with some fields
     * @return true if exemplars rectangle equals
     * false if exemplars rectangle not equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle || !super.equals(o))) return false;
        Rectangle rectangle = (Rectangle) o;
        return getWidth() == rectangle.getWidth() &&
                getHeight() == rectangle.getHeight();
    }

    /**
     * This method overrode and extended calculating hash code for concrete exemplar rectangle
     *
     * @return hash code concrete exemplar rectangle
     */
    @Override
    public int hashCode() {
        return Objects.hash(getWidth(), getHeight());
    }
}
