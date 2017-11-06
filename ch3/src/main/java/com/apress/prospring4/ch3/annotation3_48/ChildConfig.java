package com.apress.prospring4.ch3.annotation3_48;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ParentConfig.class)
public class ChildConfig {
    @Bean("target1")
    public SimpleTarget SimpleTarget1(){
        SimpleTarget ret = new SimpleTarget();
        ret.setVal(injectBean+"1");
        return ret;
    }

    @Bean("target2")
    public SimpleTarget SimpleTarget2(){
        SimpleTarget ret = new SimpleTarget();
        ret.setVal(injectBean);
        return ret;
    }

    @Bean("target3")
    public SimpleTarget SimpleTarget3(){
        SimpleTarget ret = new SimpleTarget();
        ret.setVal(injectBean);
        return ret;
    }

    public String injectBean="Child In Bean";

}
