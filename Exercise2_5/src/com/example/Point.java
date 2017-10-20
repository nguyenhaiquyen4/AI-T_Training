package com.example;

public class Point {
    double x,y;

    public Point(){
        this(0,0);
    }

    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public Point translate(double xvar, double yvar) {
        return new Point(this.x + xvar, this.y + yvar);
    }

    public Point scale(double factor) {
        return new Point(this.x * factor, this.y *= factor);
    }
}
