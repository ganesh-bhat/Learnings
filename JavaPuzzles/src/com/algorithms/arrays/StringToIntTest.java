package com.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringToIntTest {

    @Test
    public void stringToInt() {

        System.out.println(StringToInt.stringToInt("-45"));
        System.out.println(StringToInt.stringToInt("-185645"));
        System.out.println(StringToInt.stringToInt("994545"));
        System.out.println(StringToInt.stringToInt("99999999999999994545"));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(StringToInt.stringToInt("-99999999999999994545"));
        System.out.println(Integer.MIN_VALUE);

        System.out.println(StringToInt.stringToInt("       994545"));
        System.out.println(StringToInt.stringToInt("       -994545"));

    }
}
