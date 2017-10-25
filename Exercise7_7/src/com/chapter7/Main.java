package com.chapter7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String... args){
        Map<String, Integer> myMap = new TreeMap<>();

        try (FileInputStream fis = new FileInputStream("src/com/chapter7/Main.java");
             BufferedReader reader = new BufferedReader(new InputStreamReader(fis))) {
            String line = reader.readLine();
            while(line != null) {
                for (String word : getWords(line)) {
                    myMap.merge(word, 1, (x,y)->x+y);
                }
                line = reader.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        myMap.entrySet().forEach(System.out::println);
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
