package com.example;

public class Exercise2_5 {
    public static void main(String[] args){
        Point p = new Point(3,4);
        Point x = p.translate(1,3).scale(0.5);
        System.out.printf("%f__%f\n", p.getX(), p.getY());
        System.out.printf("%f__%f", x.getX(), x.getY());
    }
}
