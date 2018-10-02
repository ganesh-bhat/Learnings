package com.fire_drill.ds;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {


    static void permute(List<String> results, String input, int left, int right) {
        if (left == right) {
            results.add(input);
            return;
        }

        for (int i = left; i <= right; i++) {
            StringBuilder sb = new StringBuilder(input);
            swap(sb, left, i);
            permute(results, sb.toString(), left + 1, right);
            swap(sb, left, i);
        }
    }

    private static void swap(StringBuilder sb, int first, int second) {
        if(first == second) return;
        char firstChar = sb.charAt(first);
        sb.setCharAt(first,sb.charAt(second));
        sb.setCharAt(second,firstChar);
    }


    public static void main(String[] args) {
        List<String> results = new ArrayList<>();
        permute(results,"abc", 0, "abc".length()-1);

        System.out.println(results);
    }
}
