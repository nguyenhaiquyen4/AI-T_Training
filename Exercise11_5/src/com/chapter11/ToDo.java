package com.chapter11;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
@Repeatable(ToDos.class)
@interface ToDo {
    String message() default "";
}

@interface ToDos {
    ToDo[] value();
}
