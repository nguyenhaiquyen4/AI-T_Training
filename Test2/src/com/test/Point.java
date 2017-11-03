package com.test;

public class Point implements Cloneable {
    public double x;
    public double y;

    public Point() {
        x = 0;
        y = 0;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point a) {
        this.x = a.x;
        this.y = a.y;
    }

    public double getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point translate3(double direction) {
        x -= direction;
        y -= direction;
        try {
            return (Point) (this.clone());
        } catch (CloneNotSupportedException ex) {
        }
        return null;
    }

    public Point scale(double factor) {
        x *= factor;
        y *= factor;
        try {
            return (Point) (this.clone());
        } catch (CloneNotSupportedException ex) {
        }
        return null;
    }

    public void translate4mutable(double dx, double dy) {
        x += dx;
        y += dy;
    }

    public Point translate4immutable(double dx, double dy) {
        return new Point(x + dx, y + dy);
    }

    public void scale4(double delta) {
        x = delta;
        y = delta;
    }

    public Point scale4immutable(double delta) {
        return new Point(delta, delta);
    }

}
