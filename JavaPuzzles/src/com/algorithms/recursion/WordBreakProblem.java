package com.algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

public class WordBreakProblem {


    private static boolean wordBreak(String input, String[] dictionary) {

        Set<String> dict = new HashSet<>();
        for (String each : dictionary) {
            dict.add(each);
        }
        return wordBreak(dict, input, "", 0);

    }

    private static boolean wordBreak(Set<String> dict, String input, String prefix, int end) {
        if (end >= input.length()) {
            if (dict.contains(prefix)) {
                return true;
            } else {
                return false;
            }
        }
        if(input.charAt(end) == ' ') end++;

        if (dict.contains(prefix)) {
            return wordBreak(dict, input, "" + input.charAt(end), end+1);
        } else {
            return wordBreak(dict, input, prefix + input.charAt(end), end+1);
        }
    }


    public static void main(String[] args) {
        String[] dict = { "i", "like", "sam", "sung", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango"};
        boolean res = wordBreak("ilike",dict);
        System.out.println(res);
    }

}