package com.chapter7;

import java.io.*;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String... args){
        MyMap myMap = new MyMap();
        int lineCount = 1;

        try (FileInputStream fis = new FileInputStream("src/com/chapter7/Main.java");
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line = reader.readLine();
            while(line != null) {
                for (String word : getWords(line)) {
                    myMap.add(word, lineCount);
                }
                lineCount++;
                line = reader.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        myMap.printOut();
    }

    private static List<String> getWords(String text) {
        List<String> words = new ArrayList<>();
        BreakIterator breakIterator = BreakIterator.getWordInstance();
        breakIterator.setText(text);
        int lastIndex = breakIterator.first();
        while (BreakIterator.DONE != lastIndex) {
            int firstIndex = lastIndex;
            lastIndex = breakIterator.next();
            if (lastIndex != BreakIterator.DONE && Character.isLetterOrDigit(text.charAt(firstIndex))) {
                words.add(text.substring(firstIndex, lastIndex));
            }
        }
        return words;
    }
}
