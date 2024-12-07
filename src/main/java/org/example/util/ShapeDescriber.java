package org.example.util;

import org.example.model.Shape;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShapeDescriber {

    private static final Logger logger = LoggerFactory.getLogger(ShapeDescriber.class);


    public static void describe(Shape shape){
        double perimeter = shape.getPerimeter();
        double area = shape.getArea();

        logger.info("Perimeter: {}", perimeter);
        logger.info("Area: {}", area);
        logger.info("Describing shape: Type = {}, Color = {}", shape.getClass().getSimpleName(), shape.getColorDescription());

        System.out.println("Perimeter: ");
        System.out.println(perimeter);
        System.out.println("Area: ");
        System.out.println(area);
        System.out.println("color: ");
        System.out.println(shape.getColorDescription());
    }
}
