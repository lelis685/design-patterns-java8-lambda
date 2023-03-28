package br.com.demo.model;

import java.awt.*;

public class Circle {

    private Color color;

    public Circle(Color color) {
        this.color = color;
    }
    public Circle() {
        this(Color.WHITE);
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color=" + color +
                '}';
    }
}
