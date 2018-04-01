package com.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class RomanToDecimalTest {


    @Test
    public void romanToDecimalTest() {
        long value = RomanToDecimal.romanToDecimal("I");
        Assert.assertEquals(1, value);

        value = RomanToDecimal.romanToDecimal("II");
        Assert.assertEquals(2, value);

        value = RomanToDecimal.romanToDecimal("MIIIL");
        Assert.assertEquals(1047, value);

        value = RomanToDecimal.romanToDecimal("MCMLIV");
        Assert.assertEquals(1954, value);

        value = RomanToDecimal.romanToDecimal("MMXIV");
        Assert.assertEquals(2014, value);


        value = RomanToDecimal.romanToDecimal("XIIX");
        Assert.assertEquals(18, value);

    }
}
