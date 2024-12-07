package org.example;

import org.example.model.Color;
import org.example.model.Rectangle;
import org.example.model.Shape;
import org.example.model.Triangle;
import org.example.util.ShapeDAO;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeDAOTest {

    private static SessionFactory sessionFactory;
    private static ShapeDAO shapeDAO;

    @BeforeAll
    public static void setup() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        shapeDAO = new ShapeDAO(sessionFactory);
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testSaveAndFindById() {
        Shape rectangle = new Rectangle(4, 5, new Color(255, 100, 50, 128));
        shapeDAO.save(rectangle);

        Shape fetchedShape = shapeDAO.findById(rectangle.getId());

        assertNotNull(fetchedShape);
        assertEquals(rectangle.getArea(), fetchedShape.getArea());
        assertEquals(rectangle.getColorDescription(), fetchedShape.getColorDescription());
    }

    @Test
    public void testFindAll() {
        Shape rectangle = new Rectangle(4, 5, new Color(255, 100, 50, 128));
        Shape triangle = new Triangle(3, 4, 5, new Color(255, 100, 50, 128));
        shapeDAO.save(rectangle);
        shapeDAO.save(triangle);

        List<Shape> shapes = shapeDAO.findAll();

        assertTrue(shapes.size() >= 2);
    }

    @Test
    public void testDelete() {
        Shape rectangle = new Rectangle(4, 5, new Color(255, 100, 50, 128));
        shapeDAO.save(rectangle);

        shapeDAO.delete(rectangle);

        Shape fetchedShape = shapeDAO.findById(rectangle.getId());
        assertNull(fetchedShape);
    }
}
