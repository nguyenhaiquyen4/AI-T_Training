package com.chapter11;

public class Main {
    public static void main(String... args) throws Exception{
        Employee em1 = new Employee("Susan", 100L);
        Employee em2 = (Employee)Cloneables.clone(em1);
        em1.setSalary(200);
        em1.print();
        em2.print();
    }
}
