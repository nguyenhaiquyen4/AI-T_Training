package com.apress.prospring4.ch3.annotation3_60;

import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
public class LookupDemoConfig {

    @Bean("helper")
    public MyHelper myHelper1() {
        return new MyHelper("cc");
    }

    @Component("abstractLookupBean")
    public class MyClass1 extends AbstractLookupDemoBean {
        @Lookup
        public MyHelper getMyHelper(){
            return null; // This implementation will be overridden by dynamically generated subclass
        }
    }

    @Bean("standardLookupBean")
    public DemoBean standardLookupBean(){
        StandardLookupDemoBean ret = new StandardLookupDemoBean();
        ret.setMyHelper(myHelper1());
        return ret;
    }
}
