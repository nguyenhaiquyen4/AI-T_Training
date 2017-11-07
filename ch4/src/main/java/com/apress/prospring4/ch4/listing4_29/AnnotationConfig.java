package com.apress.prospring4.ch4.listing4_29;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class AnnotationConfig {
    @Bean("customEditorConfigurer")
    public CustomEditorConfigurer CustomEditorConfigurer() {
        CustomEditorConfigurer ret = new CustomEditorConfigurer();
        Map editors = new HashMap();
        editors.put(Name.class.getName(), new NamePropertyEditor());
        ret.setCustomEditors(editors);
        return ret;
    }

    @Bean("exampleBean")
    public CustomEditorExample CustomEditorExample() {
        CustomEditorExample ret = new CustomEditorExample();
//        ret.setName("Chris Schaefer");
        return ret;
    }// Give up
}
