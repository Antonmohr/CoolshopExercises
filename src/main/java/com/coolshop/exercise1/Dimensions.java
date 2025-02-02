package com.coolshop.exercise1;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Dimensions {
    private int length_mm;
    private int width_mm;
    private int height_mm;
    private int weight_g;

    public Dimensions(int length_mm, int width_mm, int height_mm, int weight_g){
        this.length_mm = length_mm;
        this.width_mm = width_mm;
        this.height_mm = height_mm;
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
