package com.apress.prospring4.ch5bis.listing5_74;

import org.springframework.context.support.GenericXmlApplicationContext;

public class AspectJExample {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load(new String[] {"app-config-xml-5-76.xml"});
        ctx.refresh();
        MessageWriter writer = new MessageWriter();
        writer.writeMessage();
        writer.foo();
    }
}
