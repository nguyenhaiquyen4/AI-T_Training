package com.chapter9;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.*;
import java.util.Collections;

public class Main {
    public static void main(String... args) {
        try {
            makeZip("src/com", "abc.zip");
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        catch (URISyntaxException uriex) {
            uriex.printStackTrace();
        }
    }

    private static void makeZip(String sourcename, String zipname) throws IOException, URISyntaxException{
        Path source = Paths.get(sourcename);
        Path zipPath = Paths.get(zipname);

        URI uri = new URI("jar", zipPath.toUri().toString(), null);
        try (FileSystem zipfs = FileSystems.newFileSystem(uri, Collections.singletonMap("create", "true"))) {
            Files.walk(source).forEach(p -> {
                    System.out.println("xx : " + p);
                    try {
                        Path target = zipfs.getPath("");
                        System.out.println("yy : " + target);
                        System.out.println("cc : " + source.relativize(p));
                        Path q = zipfs.getPath(source.relativize(p).toString());
                        System.out.println("zz : " + q);
                        if (q.toString().length() == 0) return;
                        if (Files.isDirectory(p))
                            Files.createDirectory(q);
                        else
                            Files.copy(p, q, StandardCopyOption.REPLACE_EXISTING);
                    }
                    catch (IOException ioex) {
                        ioex.printStackTrace();
                    }
                }
            );
        }
    }
}
