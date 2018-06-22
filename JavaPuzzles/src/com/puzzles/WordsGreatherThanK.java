package com.puzzles;

import java.util.ArrayList;
import java.util.List;

public class WordsGreatherThanK {

    public static void main(String[] args) {

        int k = 4;
        String str = "Hello I am happy today because of no reason";
        List<String> allWords = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< str.length();i++) {
            if(str.charAt(i) == ' ') {
                if(sb.length()>k) {
                  allWords.add(sb.toString());
                }
                sb.setLength(0);
            } else {
                sb.append(str.charAt(i));
            }
        }

        System.out.println(allWords);


    }
}
