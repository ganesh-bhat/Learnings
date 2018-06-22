package com.puzzles;

import java.math.BigInteger;

public class NumDigitInAnyBase {

    public static void main(String[] args) {
        String number = "458621";
        int fromBase = 82;
        int toBase = 10;
        String value = new BigInteger(number, 10).toString(toBase);
        System.out.println(value.toString()+":"+value.length());
    }
}
