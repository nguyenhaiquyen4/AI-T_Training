package com.chapter3;

public class Employee {
    public int salary;
    public String name;

    public Employee(int s){
        salary = s;
    }

    public Employee(String name, int s){
        this.name = name;
        this.salary = s;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }
}
