package com.apress.prospring4.ch3.annotation3_65;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

public class MethodReplacementExample {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-xml-3-67.xml");
//        ctx.refresh();
//        ReplacementTarget replacementTarget = (ReplacementTarget) ctx
//                .getBean("replacementTarget");
//        ReplacementTarget standardTarget = (ReplacementTarget) ctx
//                .getBean("standardTarget");
//        displayInfo(replacementTarget);
//        displayInfo(standardTarget);


        ApplicationContext ctx = new AnnotationConfigApplicationContext(MethodReplaceConfig.class);

        ReplacementTarget replacementTarget = (ReplacementTarget) ctx.getBean("replacementTarget1");
        ReplacementTarget standardTarget = (ReplacementTarget) ctx.getBean("standardTarget");
        displayInfo(replacementTarget);
        displayInfo(standardTarget);

    }

    private static void displayInfo(ReplacementTarget target) {
        System.out.println(target.formatMessage("Hello World!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int x = 0; x < 10; x++) {
            String out = target.formatMessage("foo");
        }
        stopWatch.stop();
        System.out.println("1000000 invocations took: "
                + stopWatch.getTotalTimeMillis() + " ms");
    }
}
