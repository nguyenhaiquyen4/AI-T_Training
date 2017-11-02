package com.chapter14;

import javax.script.*;

public class Main {
    public static void main(String... args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        Bindings scope = engine.createBindings();

        // (a) with eval
        Object obj1 = engine.eval("a=JSON.parse('{ \"name\":\"John\", \"age\":30, \"city\":\"New York\"}')");
        System.out.println(engine.eval("a.name"));

        // (b) with invokeMethod
        Object jo = engine.get("JSON");
        Object obj2 = ((Invocable)engine).invokeMethod(jo,"parse","{ \"name\":\"John\", \"age\":30, \"city\":\"New York\"}");

        // (c) by a Java method call through the interface
        jo = engine.get("JSON");
        JSON myJSON = ((Invocable) engine).getInterface(jo,JSON.class);
        Object obj3 = myJSON.parse("{ \"name\":\"John\", \"age\":30, \"city\":\"New York\"}");
    }
}

//How to check that b,c work correct ?
