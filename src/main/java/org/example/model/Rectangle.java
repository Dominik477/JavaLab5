package org.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Rectangle")
public class Rectangle extends Shape {
    private int a;
    private int b;

    public Rectangle() {
    }

    public Rectangle(int a, int b, Color color) {
        super(color);
        this.a = a;
        this.b = b;
        this.area = a * b;
        this.perimeter = 2 * this.a + 2 * this.b;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public double getPerimeter() {
        return this.perimeter;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }
}
