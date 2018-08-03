package com.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringZigZagTest {

    @Test
    public void test() {
        System.out.println(StringZigZag.zigZag("PAYPALISHIRING",2));
        System.out.println(StringZigZag.zigZag("PAYPALISHIRING",3));
        System.out.println(StringZigZag.zigZag("PAYPALISHIRING",4));
        System.out.println(StringZigZag.zigZag("PAYPALISHIRING",5));

    }

}