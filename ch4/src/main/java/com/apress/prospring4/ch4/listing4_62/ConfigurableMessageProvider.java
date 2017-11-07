//package com.apress.prospring4.ch4.listing4_62;
//
//import javax.inject.Inject;
//import javax.inject.Named;
//
//@Named("messageProvider")
//public class ConfigurableMessageProvider implements MessageProvider {
//    private String message = "Default message";
//
//    public ConfigurableMessageProvider() {
//    }
//
//    @Inject
//    @Named("message")
//    public ConfigurableMessageProvider(String message) {
//        this.message = message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//
//    @Override
//    public String getMessage() {
//        return message;
//    }
//}
