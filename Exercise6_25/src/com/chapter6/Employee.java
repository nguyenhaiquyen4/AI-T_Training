package com.chapter6;

public class Employee {
    static {
        System.out.println("hello a demain");
    }
    protected double salary;
    private String name = "";

    public Employee() {
        this.name = "Ohoho";
    }

    public Employee(double s){
        salary = s;
    }

    public Employee(String name){
        this.name = name;
        this.salary = 0;
    }

    public Employee(String name, double salary){
        this.name = name;
        this.salary = salary;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean worksFor(Employee supervisor) {
        return true;
    }

    public Employee getSupervisor() {
        return null;
    }

    public int compareTo(Employee another){
        return Double.compare(salary, another.salary);
    }
}
