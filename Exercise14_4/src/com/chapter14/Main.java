package com.chapter14;

import javax.script.*;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String... args) throws IOException, ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        engine.eval(Files.newBufferedReader(Paths.get("factorial.js"), Charset.defaultCharset()));
        Invocable inv = (Invocable) engine;
        Object obj = inv.invokeFunction("factorial", "5");
        System.out.println(obj);
    }
}
