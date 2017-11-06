package com.apress.prospring4.ch3.annotation3_60;

public class MyHelper {
    private String abc;

    public MyHelper(String abc) {
        this.abc = abc;
    }

    public void doSomethingHelpful() {
        System.out.println(abc+"aa");
        // do something!
    }
}
