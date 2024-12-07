package org.example;

import org.example.model.Color;
import org.example.model.Rectangle;
import org.example.model.Shape;
import org.example.model.Triangle;
import org.example.util.ShapeRenderer;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Color color1 = new Color(255, 100, 50, 128);
        Color color2 = new Color(0, 255, 0);

        Rectangle rectangle = new Rectangle(5, 7, color1);
        Triangle triangle = new Triangle(6,8,10, color2);

//        ShapeDescriber.describe(rectangle);
//        ShapeDescriber.describe(triangle);

        List<Shape> shapes = new ArrayList<>();
        shapes.add(rectangle);
        shapes.add(triangle);

        ShapeRenderer.renderShapes(shapes);

    }
}


