package com.chapter4;

public class Main {
    public static void main(String ... args) {
        LabeledPoint labeledPoint = new LabeledPoint("MyLabel", 4, 1);
        Point point = new Point(2, 3);
        System.out.println(labeledPoint.label);
    }
}
