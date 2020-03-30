package com.epam.belousov.generativepatterns.prototype;

import java.util.Objects;

/**
 * This class extends on Shape abstract class and realize concrete exemplar shape - circle
 */
public class Circle extends Shape {
    private int radius;

    public Circle() {
    }

    public Circle(Circle param) {
        super(param);

        if (param != null) {
            this.radius = param.radius;
        }
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * This overrode method clone some circle
     *
     * @return cloned concrete circle
     */
    @Override
    public Shape clone() {
        return new Circle(this);
    }

    /**
     * This overrode method equals for compare two exemplar circle
     *
     * @param o - input compared some circle with some fields
     * @return true if exemplars circle equals
     * false if exemplars circle not equals
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle) || !super.equals(o)) return false;
        Circle circle = (Circle) o;
        return getRadius() == circle.getRadius();
    }

    /**
     * This method overrode and extended calculating hash code for concrete exemplar circle
     *
     * @return hash code concrete exemplar circle
     */
    @Override
    public int hashCode() {
        return Objects.hash(getRadius());
    }
}
