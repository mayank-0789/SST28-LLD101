package com.example.map;

/**
 * Immutable Flyweight representing the intrinsic (shared) style of a map marker.
 * Instances are created and cached exclusively by MarkerStyleFactory.
 */
public class MarkerStyle {

    private final String shape;   // e.g., PIN, CIRCLE, SQUARE
    private final String color;   // e.g., RED, BLUE, GREEN
    private final int size;       // e.g., 10..20
    private final boolean filled; // filled vs outline

    public MarkerStyle(String shape, String color, int size, boolean filled) {
        this.shape = shape;
        this.color = color;
        this.size = size;
        this.filled = filled;
    }

    public String getShape() { return shape; }
    public String getColor() { return color; }
    public int getSize() { return size; }
    public boolean isFilled() { return filled; }

    @Override
    public String toString() {
        return shape + "|" + color + "|" + size + "|" + (filled ? "F" : "O");
    }
}
