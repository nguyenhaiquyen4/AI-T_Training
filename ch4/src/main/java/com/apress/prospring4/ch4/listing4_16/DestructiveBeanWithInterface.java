package com.apress.prospring4.ch4.listing4_16;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.File;

public class DestructiveBeanWithInterface {
    private File file;
//    @Value("#{systemProperties['java.io.tmpdir']}#{systemProperties['file.separator']}test.txt")
    private String filePath;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {
        System.out.println("Initializing Bean");
        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " +
                            DestructiveBeanWithInterface.class);
        }
        System.out.println(filePath);
        this.file = new File(filePath);
        this.file.createNewFile();
        System.out.println("File exists: " + file.exists());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying Bean");
        if(!file.delete()) {
            System.err.println("ERROR: failed to delete file.");
        }
        System.out.println("File exists: " + file.exists());
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {
//        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
//        ctx.load("app-context-annotation-4-17.xml");
//        ctx.registerShutdownHook();
//        ctx.refresh();

        AnnotationConfigApplicationContext ctx = null;
        ctx = new AnnotationConfigApplicationContext(AnnotationConfig.class);

        DestructiveBeanWithInterface bean =
                (DestructiveBeanWithInterface) ctx.getBean("destructiveBean");
    }
}
