package com.algorithms.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

public class FindNumStringsPermutationTest {

    @Test
    public void test() {
        int totalCount = FindNumStringsPermutation.countStringsWithConstraints(3);
        System.out.println(totalCount);
    }

}