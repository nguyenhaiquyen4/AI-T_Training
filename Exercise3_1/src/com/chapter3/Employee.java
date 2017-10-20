package com.chapter3;

public class Employee implements Measurable {
    private double salary;
    private String name;

    public Employee(double sal, String n) {
        salary = sal;
        name = n;
    }

    @Override
    public double getMeasure() {
        return 0;
    }

    public static double average(Measurable[] objects) {
        double sum = 0;
        for (Measurable obj:objects) {
            sum += obj.getMeasure();
        }
        int count = objects.length;
        return count == 0 ? 0.0 : sum/count;
    }

    public double getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public static Measurable largest(Measurable[] objects) {
        Employee max = new Employee(0.0, null);
        for (Measurable obj:objects) {
            if (max.getSalary() < ((Employee)obj).getSalary()) {
                max = (Employee)obj;
            }
        }
        return (Measurable)max;
    }
}
