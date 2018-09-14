package com.puzzles;

import java.util.HashMap;
import java.util.Map;

public class DecimalConversion {

    private static final int HEXA = 16;
    private static Map<Byte, String> hexaVals = new HashMap<>();
    static {
        hexaVals.put((byte)10,"A");
        hexaVals.put((byte)11,"B");
        hexaVals.put((byte)12,"C");
        hexaVals.put((byte)13,"D");
        hexaVals.put((byte)14,"E");
        hexaVals.put((byte)15,"F");
    }

    public static void main(String[] args) {
        String binary = convert(24342,16);
        System.out.println(binary+","+Integer.toString(24342,16));

    }

    public static String convert(int number, int base) {
        StringBuilder sb = new StringBuilder();
        int rem;
        int value = number;

        while(value > 0 ) {
            rem = value % base;
            value = value/base;
            sb.append(getEquivalentValInBase(rem,base));
        }
        return sb.reverse().toString();
    }

    private static String getEquivalentValInBase(int val, int base) {
        if(base == HEXA && hexaVals.containsKey((byte)val)) {
            return hexaVals.get((byte)val);
        }
        return String.valueOf(val);
    }
}
