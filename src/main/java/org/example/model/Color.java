package org.example.model;

import jakarta.persistence.Embeddable;

@Embeddable
public record Color(int red, int green, int blue, int alpha) {

    public Color {
        if (red < 0 || red > 255 || green < 0 || green > 255 || blue < 0 || blue > 255 || alpha < 0 || alpha > 255) {
            throw new IllegalArgumentException("Wartości kolorów muszą mieścić się w przedziale 0-255");
        }
    }

    public Color(int red, int green, int blue) {
        this(red, green, blue, 255);
    }


@Override
    public int red() {
        return red;
    }

    @Override
    public int green() {
        return green;
    }

    @Override
    public int blue() {
        return blue;
    }

    @Override
    public int alpha() {
        return alpha;
    }
}