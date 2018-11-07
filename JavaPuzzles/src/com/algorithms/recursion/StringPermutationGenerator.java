package com.algorithms.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutationGenerator{


    public static List<String> permutations(String str) {
        if(str == null) return null;
        if(str.length() == 0 || str.length() == 1 ) {
            return Arrays.asList(str);
        }

        char firstChar = str.charAt(0);
        List<String> words = permutations(str.substring(1));

        List<String> permuts = new ArrayList<>();
        for(String word: words ) {
            for(int i=0;i<=word.length();i++) {
                String newWord = insertCharAt(word, firstChar,i);
                permuts.add(newWord);
            }

        }
        return permuts;
    }

    private static String insertCharAt(String word,
                                       char ch, int index) {
        String start=word.substring(0,index);
        String end = word.substring(index, word.length());
        return start+ch+end;

    }


    public static void main(String[] args) {
        String str = "abc";
        List<String> permutations = permutations(str);
        System.out.println(permutations); //5! permutations
    }

}

