package com.test;

import java.util.Scanner;

public class Main {
    public static void main(String... args) {
        Scanner in = new Scanner(System.in);
        System.out.println("What is your number?");
        int name = Integer.parseInt(in.nextLine());
        System.out.printf("Binary : %s \n", Integer.toBinaryString(name));
        System.out.printf("Octa   : %o \n", name);
        System.out.printf("Hexa   : %x \n", name);

        System.out.println("What is your double number?");
        double d = Double.parseDouble(in.nextLine());
        System.out.printf("Hexa Floating   : %a ", d);
    }


}
