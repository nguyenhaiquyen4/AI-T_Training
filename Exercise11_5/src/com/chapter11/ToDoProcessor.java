package com.chapter11;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.annotation.Annotation;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

@SupportedAnnotationTypes("com.chapter11.ToDo")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class ToDoProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        if (annotations.size() == 0) return true;
            try (PrintWriter out = new PrintWriter(Files.newOutputStream(Paths.get("ReminderList.txt")))){
                out.println("Reminder list from "+roundEnv.getRootElements());
                out.println("annotations "+annotations);
                for (Element e:roundEnv.getElementsAnnotatedWith(ToDo.class)) {
                    writeToStringMethod(out, e);
                }
            } catch (Exception ex) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, "ecec "+ex.getMessage());
            }
        return true;
    }

    private static void writeToStringMethod(PrintWriter out, Element te) {
        ToDo ann = te.getAnnotation(ToDo.class);
        out.println("message of "+te.getSimpleName().toString()+":"+ann.message());
        for (Element c : te.getEnclosedElements()) {
            ann = c.getAnnotation(ToDo.class);
            if (ann != null) {
                out.println("message of "+c.getSimpleName().toString()+":"+ann.message());
            }
        }
    }
}
