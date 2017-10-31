package com.chapter11;

@Cloneable
public class Employee {
    private String name;
    private long salary;

    public Employee() {
    }

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public Employee(String name, long salary) {

        this.name = name;
        this.salary = salary;
    }

    public void print() {
        System.out.println(name + " : " + salary);
    }
}
