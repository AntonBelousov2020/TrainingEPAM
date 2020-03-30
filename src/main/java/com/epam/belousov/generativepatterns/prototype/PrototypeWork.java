package com.epam.belousov.generativepatterns.prototype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * This class describes Prototype work
 */
public class PrototypeWork {
    private static final Logger log = LoggerFactory.getLogger(PrototypeWork.class);
    private List<Shape> shapes = new ArrayList<>();
    private List<Shape> shapesCopy = new ArrayList<>();

    /**
     * This method realize main logic for prototype. This method initializes some circles and rectangle,
     * also create and initializes two lists for it compare later
     */
    public void configure() {
        log.info("\n");
        log.info("Prototype");

        Circle circle = new Circle();
        circle.setX(5);
        circle.setY(10);
        circle.setRadius(15);
        circle.setColor("green");
        shapes.add(circle);

        Circle circleClone = (Circle) circle.clone();
        shapes.add(circleClone);

        Circle anotherCircle = new Circle();
        circle.setX(10);
        circle.setY(15);
        circle.setRadius(8);
        circle.setColor("blue");
        shapes.add(anotherCircle);

        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(10);
        rectangle.setHeight(8);
        rectangle.setColor("orange");
        shapes.add(rectangle);

        Rectangle rectangleClone = (Rectangle) rectangle.clone();
        shapes.add(rectangleClone);

        cloneAndCompare(shapes, shapesCopy);
    }

    /**
     * This method clone list of some objects to other list, and compare objects on first list with relevant objects
     * on other list
     *
     * @param shapes     - input list with some objects
     * @param shapesCopy - input empty list for clone on it some objects
     */
    private static void cloneAndCompare(List<Shape> shapes, List<Shape> shapesCopy) {
        for (Shape shape : shapes) {
            shapesCopy.add(shape.clone());
        }

        for (int i = 0; i < shapes.size(); i++) {
            if (shapes.get(i) != shapesCopy.get(i)) {
                log.info(i + " Shapes are different objects");
                if (shapes.get(i).equals(shapesCopy.get(i))) {
                    log.info(i + " This shapes identical");
                } else {
                    log.info(i + " This shapes are not identical");
                }
            } else {
                log.info(i + " Shapes object are the same");
            }
        }
    }
}
