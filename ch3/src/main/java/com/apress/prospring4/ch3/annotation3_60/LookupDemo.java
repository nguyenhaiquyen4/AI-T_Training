package com.apress.prospring4.ch3.annotation3_60;

import com.apress.prospring4.ch3.annotation3_43.InjectSimpleSpel;
import com.apress.prospring4.ch3.annotation3_43.InjectSimpleSpelConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

public class LookupDemo {
    public static void main(String[] args) {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-xml-3-60.xml");
//        ctx.refresh();
//        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
//        DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
//        displayInfo(standardBean);
//        displayInfo(abstractBean);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(LookupDemoConfig.class);

        DemoBean abstractBean = (DemoBean) ctx.getBean("abstractLookupBean");
        DemoBean standardBean = (DemoBean) ctx.getBean("standardLookupBean");
        displayInfo(standardBean);
        displayInfo(abstractBean);
    }
    public static void displayInfo(DemoBean bean) {
        MyHelper helper1 = bean.getMyHelper();
        MyHelper helper2 = bean.getMyHelper();
        System.out.println("Helper Instances the Same?: "
                + (helper1 == helper2));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("lookupDemo");
        for (int x = 0; x < 10; x++) {
            MyHelper helper = bean.getMyHelper();
            helper.doSomethingHelpful();
        }
        stopWatch.stop();
        System.out.println("100000 gets took " + stopWatch.getTotalTimeMillis() + " ms");
    }
}
