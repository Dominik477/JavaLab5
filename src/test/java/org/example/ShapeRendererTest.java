package org.example;

import org.example.model.Color;
import org.example.model.Rectangle;
import org.example.model.Shape;
import org.example.model.Triangle;
import org.example.util.ShapeRenderer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ShapeRendererTest {

    @Test
    public void testRenderShapes() {
        Shape rectangle = new Rectangle(4, 5, new Color(255, 100, 50, 128));
        Shape triangle = new Triangle(3, 4, 5, new Color(255, 100, 50, 128));

        List<Shape> shapes = Arrays.asList(rectangle, triangle);

        ShapeRenderer.renderShapes(shapes);

    }
}
