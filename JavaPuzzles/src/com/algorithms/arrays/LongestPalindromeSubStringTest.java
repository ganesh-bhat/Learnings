package com.algorithms.arrays;

import org.junit.Test;

public class LongestPalindromeSubStringTest {

    @Test
    public void test() {
        String palindromeSuper = "adefabcfddfcbahmla";
        String pali = LongestPalindromeSubString.optimum(palindromeSuper);
        System.out.println(pali);

        pali = LongestPalindromeSubString.dynamicProgramming(palindromeSuper);
        System.out.println(pali);
    }

}