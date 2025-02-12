package com.coolshop.exercise1;

public class Dimensions {
    private int length_mm;
    private int width_mm;
    private int height_mm;
    private int weight_g;

    public Dimensions(int length_mm, int width_mm, int height_mm, int weight_g) {
        this.length_mm = length_mm;
        this.width_mm = width_mm;
        this.height_mm = height_mm;
        this.weight_g = weight_g;
    }

    public int getLength_mm() {
        return length_mm;
    }

    public int getWidth_mm() {
        return width_mm;
    }

    public int getHeight_mm() {
        return height_mm;
    }

    public int getWeight_g() {
        return weight_g;
    }

    public void setLength_mm(int length_mm) {
        this.length_mm = length_mm;
    }

    public void setWidth_mm(int width_mm) {
        this.width_mm = width_mm;
    }

    public void setHeight_mm(int height_mm) {
        this.height_mm = height_mm;
    }

    public void setWeight_g(int weight_g) {
        this.weight_g = weight_g;
    }

    @Override
    public String toString() {
        return "Dimensions {" +
                "length_mm=" + length_mm +
                ", width_mm=" + width_mm +
                ", height_mm=" + height_mm +
                ", weight_g=" + weight_g +
                '}';
    }
}
