package com.chapter14;

public interface JSON {
    Object parse(String str);
    String stringify(Object obj);
}
