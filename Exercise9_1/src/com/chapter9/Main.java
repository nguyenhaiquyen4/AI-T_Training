package com.chapter9;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Main {
    public static void main(String... args) {
        try (InputStream in = Files.newInputStream(Paths.get("src/com/chapter9/Main.java"));
            OutputStream out = Files.newOutputStream(Paths.get("copyFromUseLoop.txt")) ){
            copyFromUseLoop(in, out);
        }
        catch (IOException ex) {
                ex.printStackTrace();
        }

        try (InputStream in = Files.newInputStream(Paths.get("src/com/chapter9/Main.java"));
             OutputStream out = Files.newOutputStream(Paths.get("copyFromUseFile.txt")) ){
            copyFromUseFile(in, out);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void copyFromUseLoop(InputStream input, OutputStream output) throws IOException {
        while (input.available() > 0) {
            output.write(input.read());
        }
    }

    private static void copyFromUseFile(InputStream input, OutputStream output) throws IOException {
        Path tempfile = Files.createTempFile("Chapter9_", ".tmp");
        Files.copy(input, tempfile, StandardCopyOption.REPLACE_EXISTING);
        Files.copy(tempfile, output);
    }
}
