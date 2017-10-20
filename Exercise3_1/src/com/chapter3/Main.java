package com.chapter3;

public class Main {
    public static void main(String[] args) {
        Employee mot = new Employee(100.0, "Mot");
        Employee hai = new Employee(200.0, "Hai");
        Employee ba = new Employee(50.0, "Ba");
        Employee[] employees = {mot, hai, ba};
        System.out.println(Employee.average(employees));
        System.out.println(((Employee)Employee.largest(employees)).getName());
    }
}
