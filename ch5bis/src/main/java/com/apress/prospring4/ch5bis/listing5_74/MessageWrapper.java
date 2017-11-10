package com.apress.prospring4.ch5bis.listing5_74;

import org.aspectj.lang.annotation.Pointcut;

public class MessageWrapper {
    private String prefix;
    private String suffix;

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return this.prefix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return this.suffix;
    }

//    @Pointcut("execution(*com.apress.prospring4.ch5bis.listing5_74.MessageWriter.writeMessage())")
//    public void doWriting() {
//        System.out.println(prefix);
//    }
//
//    execution(*com.apress.prospring4.ch5bis.listing5_74.MessageWriter.writeMessage());
//
//    before() : doWriting() {
//    }
//
//    after() : doWriting() {
//        System.out.println(suffix);
//    }
}
