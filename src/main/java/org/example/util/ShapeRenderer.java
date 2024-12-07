package org.example.util;

import org.example.model.Rectangle;
import org.example.model.Shape;
import org.example.model.Triangle;

import java.util.List;

public class ShapeRenderer {

    public static void renderShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            System.out.println("Rendering Shape:");
            System.out.println("Type: " + shape.getClass().getSimpleName());
            System.out.println("Color: " + shape.getColorDescription());
            System.out.println("Area: " + shape.getArea());
            System.out.println("Perimeter: " + shape.getPerimeter());
            System.out.println(drawShape(shape));
            System.out.println("======================================");
        }
    }

    private static String drawShape(Shape shape) {
        if (shape instanceof Rectangle) {
            return drawRectangle((Rectangle) shape);
        } else if (shape instanceof Triangle) {
            return drawTriangle((Triangle) shape);
        } else {
            return "Some error";
        }
    }

    private static String drawRectangle(Rectangle rectangle) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rectangle.getA(); i++) {
            sb.append("* ".repeat(rectangle.getB())).append("\n");
        }
        return sb.toString();
    }

    private static String drawTriangle(Triangle triangle) {
        StringBuilder sb = new StringBuilder();
        int height = Math.min(triangle.getA(), 10);
        for (int i = 1; i <= height; i++) {
            sb.append(" ".repeat(height - i));
            sb.append("* ".repeat(i)).append("\n");
        }
        return sb.toString();
    }
}
