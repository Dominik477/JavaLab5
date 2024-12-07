package org.example;

import org.example.model.Color;
import org.example.model.Triangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @Test
    public void testTriangleArea() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(255, 100, 50, 128));
        assertEquals(6, triangle.getArea(), "Area should be 6");
    }

    @Test
    public void testTrianglePerimeter() {
        Triangle triangle = new Triangle(3, 4, 5, new Color(255, 100, 50, 128));
        assertEquals(12, triangle.getPerimeter(), "Perimeter should be 12");
    }
}
