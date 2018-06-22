package com.puzzles;

import java.util.Arrays;

public class ReversePostRemovalVovels {

    public static void main(String[] args) {
        String str = "geeksforgeeks";

        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        StringBuilder out = new StringBuilder();

        for(int i=0;i<str.length();i++) {
            if(!isVovel(str.charAt(i))) {
                out.append(sb.charAt(i));
            }
        }
        System.out.println(out.toString());

    }

    private static boolean isVovel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
