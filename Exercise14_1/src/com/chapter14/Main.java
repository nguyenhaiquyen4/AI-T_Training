package com.chapter14;

import javax.script.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String... args) throws IOException, ScriptException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("outfile.html"));

        Scanner scanner = new Scanner(new File("sample.html"));
        scanner.useDelimiter("<%");

        while (scanner.hasNext()) {
            String next = scanner.next().replace("%>", "");
            writer.append(next);
            scanner.useDelimiter("%>");
            if (!scanner.hasNext()) {
                break;
            }
            String javaCode = scanner.next();
            boolean write = false;
            if (javaCode.startsWith("<%=")) {
                write = true;
                javaCode = javaCode.replace("<%=", "");
            } else {
                javaCode = javaCode.replace("<%", "");
            }
            CompiledScript script = ((Compilable) engine).compile(javaCode);
            StringWriter output = new StringWriter();
            engine.getContext().setWriter(output);
            script.eval();
            if (write) {
                System.out.println(output);
            }
            writer.write(output.toString());
            scanner.useDelimiter("<%");
        }
        writer.close();
    }
}
