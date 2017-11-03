package com.test;

public class LabeledPoint extends Point {
    private String label;
    public LabeledPoint(String label, double x, double y) {
        super(x,y);
        this.label=label;
    }

    public String getLabel() {
        return label;
    }

    public static double readValue(String x) throws NumberFormatException {
        return Double.parseDouble(x);
    }
}
