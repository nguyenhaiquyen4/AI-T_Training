package com.apress.prospring4.ch4.listing4_42;

public class ConfigurableMessageProvider implements MessageProvider {
    private String message = "Default message";
    public ConfigurableMessageProvider() {
    }
    public ConfigurableMessageProvider(String message) {
        this.message = message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}