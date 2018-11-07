package com.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LongestCommonPrefixTest {

    @Test
    public void test() {
       String prefix =  LongestCommonPrefix.longestCommonPrefix(new String[]{"flower","flow","flight"});
        assertEquals("fl", prefix);

        prefix =  LongestCommonPrefix.longestCommonPrefix(new String[]{"flo","flo","flo"});
        assertEquals("flo", prefix);

        prefix =  LongestCommonPrefix.longestCommonPrefix(new String[]{"flower","flo","flo"});
        assertEquals("flo", prefix);
    }

}