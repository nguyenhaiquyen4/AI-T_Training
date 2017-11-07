package com.apress.prospring4.ch4.listing4_27;

import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.regex.Pattern;

@Configuration
public class AnnotationConfig {
    @Bean("customEditorConfigurer")
    public CustomEditorConfigurer CustomEditorConfigurer() {
        CustomEditorConfigurer ret = new CustomEditorConfigurer();
        ret.setPropertyEditorRegistrars(propertyEditorRegistrarsList());
        return ret;
    }

    @Bean("propertyEditorRegistrarsList")
    public PropertyEditorBean.CustomPropertyEditorRegistrar[] propertyEditorRegistrarsList() {
        PropertyEditorBean.CustomPropertyEditorRegistrar[] ret = new PropertyEditorBean.CustomPropertyEditorRegistrar[1];
        ret[0] = new PropertyEditorBean.CustomPropertyEditorRegistrar();
        return ret;
    }

    @Bean("builtInSample")
    public PropertyEditorBean PropertyEditorBean() {
        PropertyEditorBean ret = new PropertyEditorBean();
        ret.setBytes("Hello World".getBytes());
        ret.setCls(java.lang.String.class);
        ret.setTrueOrFalse(Boolean.TRUE);
        ret.setStringList(stringList());
        try {
            ret.setStream(Files.newInputStream(Paths.get("test.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ret.setFloatValue(123.45678f);
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yy");
        String dateInString = "05/03/13";
        try {
            ret.setDate(formatter.parse(dateInString));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ret.setFile(new File(System.getProperty("java.io.tmpdir")+System.getProperty("file.separator")+"test.txt"));
        ret.setLocale(Locale.forLanguageTag("en-US"));
        ret.setPattern(Pattern.compile("a*b"));
        Properties p = new Properties();
        try {
            p.load(new StringReader("name=Chris age=32"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        ret.setProperties(p);
        ret.setTrimString("   String need trimming   ".trim());
        try {
            ret.setUrl(new URL("http://www.springframework.org"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Bean("stringList")
    public List stringList() {
        List ret = new ArrayList<>();
        ret.add("String member 1");
        ret.add("String member 2");
        return ret;
    }
}
