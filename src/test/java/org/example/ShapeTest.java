package org.example;

import org.example.model.Color;
import org.example.model.Rectangle;
import org.example.model.Shape;
import org.example.model.Triangle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    private static SessionFactory sessionFactory;

    @BeforeAll
    public static void setup() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();
    }

    @AfterAll
    public static void tearDown() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }

    @Test
    public void testTableCreation() {
        try (Session session = sessionFactory.openSession()) {
            var query = session.createNativeQuery("SELECT * FROM Shape");
            assertNotNull(query);
        }
    }

    @Test
    public void testSaveShape() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Shape rectangle = new Rectangle(4, 5, new Color(255, 0, 0));
            session.save(rectangle);

            transaction.commit();

            Shape savedShape = session.get(Rectangle.class, rectangle.getId());
            assertNotNull(savedShape);
            assertEquals(20.0, savedShape.getArea());
        }
    }

    @Test
    public void testUpdateShape() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Shape rectangle = new Rectangle(4, 5, new Color(0, 255, 0));
            session.save(rectangle);
            transaction.commit();

            Transaction updateTransaction = session.beginTransaction();
            rectangle = session.get(Rectangle.class, rectangle.getId());
            rectangle.color = new Color(0, 0, 255); // Zmiana koloru
            session.update(rectangle);
            updateTransaction.commit();

            Shape updatedShape = session.get(Rectangle.class, rectangle.getId());
            assertEquals(0, updatedShape.color.red());
            assertEquals(0, updatedShape.color.green());
            assertEquals(255, updatedShape.color.blue());
        }
    }

    @Test
    public void testDeleteShape() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Shape triangle = new Triangle(3, 4, 5, new Color(255, 255, 0));
            session.save(triangle);
            transaction.commit();

            Transaction deleteTransaction = session.beginTransaction();
            triangle = session.get(Triangle.class, triangle.getId());
            session.delete(triangle);
            deleteTransaction.commit();

            Shape deletedShape = session.get(Triangle.class, triangle.getId());
            assertNull(deletedShape);
        }
    }
}
