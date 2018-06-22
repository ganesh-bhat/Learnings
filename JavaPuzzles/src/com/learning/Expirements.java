package com.learning;

/**
 * Created by ganes on 20-06-2018.
 */
public class Expirements {

    public static void main(String[] args) {
        //System.out.println(tableSizeFor(34));
        //testBitwiseAndMod();
        System.out.println(13>>1);
    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return n + 1;
    }


    private static void testBitwiseAndMod() {
        int code = 15;

        int size = 32;

        System.out.println(Integer.toBinaryString(code));
        System.out.println(Integer.toBinaryString(size));
        System.out.println(Integer.toBinaryString((size -1) & code));
        System.out.println((size -1) & code);
        System.out.println(Integer.toBinaryString(code % (size -1)));
        System.out.println(code % (size -1));


    }
}
