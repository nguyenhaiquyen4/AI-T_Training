package com.apress.prospring4.ch3.annotation3_65;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MethodReplaceConfig {
    @Bean("methodReplacer")
    public FormatMessageReplacer FormatMessageReplacer() {
        FormatMessageReplacer ret = new FormatMessageReplacer();
        return ret;
    }

    @Bean({"replacementTarget","replacementTarget1"})
    public ReplacementTarget replacementTarget(){
        ReplacementTarget ret = new ReplacementTarget();
        try {
            String args[] = {"",""};
//            How to put the result to ret object ????
            FormatMessageReplacer().reimplement(ret, ReplacementTarget.class.getMethod("formatMessage",String.class), args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return ret;
    }

    @Bean("standardTarget")
    public ReplacementTarget standardTarget() {
        ReplacementTarget ret = new ReplacementTarget();
        return ret;
    }
}
