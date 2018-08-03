package com.algorithms.permutationCombination;

import java.util.ArrayList;
import java.util.List;

public class PermuteString {

    public static List<String> permutes(String input) {
        List<String> list = new ArrayList<>();
        permutes(list,input,0,input.length()-1);
        return list;
    }

    private static List<String> permutes(List<String> list, String input, int left, int right) {
        if(left == right) {
            list.add(input);
        }
        StringBuilder sb;
        for(int i=left;i<=right;i++) {
            sb = new StringBuilder(input);
            swap(sb,left,i);
            permutes(list,sb.toString(),left+1,right);
            swap(sb,left,i);
        }
        return list;
    }

    private static void swap(StringBuilder sb, int i, int j) {
        if(i == j) return;
        char c = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, c);
    }

    public static void main(String[] args) {
        List<String> list = permutes("abc");
        System.out.println(list);
    }
}
