package com.apress.prospring4.ch3.annotation3_25;

import org.springframework.stereotype.Service;

public class HelloWorldMessageProvider implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello World!";
    }
}