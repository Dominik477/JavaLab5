package org.example.model;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Shape {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    protected double area;
    protected double perimeter;

    @Embedded
    protected Color color;

    public Shape() {
    }

    public Shape(Color color) {
        this.color = color;
    }

    public void print() {
        System.out.println(this.getClass().getSimpleName());
    }

    public Long getId() {
        return id;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    public String getColorDescription() {
        return "Red: " + this.color.red() + ", Green: " + this.color.green() + ", Blue: " + this.color.blue() + ", Alpha: " + this.color.alpha();
    }
}
