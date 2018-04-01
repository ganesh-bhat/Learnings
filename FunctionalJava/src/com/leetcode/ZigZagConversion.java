package com.leetcode;

import org.junit.Assert;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
        //
    }

    public static void main(String[] args) {
        String val = new ZigZagConversion().convert("PAYPALISHIRING", 3);
        Assert.assertEquals("PAHNAPLSIIGYIR", val);
    }
}
