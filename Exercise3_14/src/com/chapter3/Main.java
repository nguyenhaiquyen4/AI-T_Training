package com.chapter3;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Employee[] aa = new Employee[6];
        aa[0] = new Employee("Mot", 200);
        aa[1] = new Employee("Hai", 400);
        aa[2] = new Employee("Ba", 100);
        aa[3] = new Employee("Bon", 200);
        aa[4] = new Employee("Nam", 400);
        aa[5] = new Employee("Sau", 100);

        Arrays.sort(aa, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName).reversed());
        for (int i =0;i<aa.length;i++){
            System.out.println(aa[i].getName());
        }
    }
}
