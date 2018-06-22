package com.puzzles;

public class ValueOfKthBit {

    public static void main(String[] args) {
        int k = 2;
        long num = 10;
        int bitMask = 1<<(k-1);
        System.out.println(((num & bitMask) > 0)? 1:0);
    }
}
