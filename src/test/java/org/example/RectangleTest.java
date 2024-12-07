package org.example;

import org.example.model.Color;
import org.example.model.Rectangle;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {

    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle(4, 5, new Color(255, 100, 50, 128));
        assertEquals(20, rectangle.getArea(), "Area should be 20");
    }

    @Test
    public void testRectanglePerimeter() {
        Rectangle rectangle = new Rectangle(4, 5, new Color(255, 100, 50, 128));
        assertEquals(18, rectangle.getPerimeter(), "Perimeter should be 18");
    }
}
