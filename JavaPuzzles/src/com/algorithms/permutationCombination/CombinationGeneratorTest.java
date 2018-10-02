package com.algorithms.permutationCombination;

import org.junit.Test;

import static org.junit.Assert.*;

public class CombinationGeneratorTest {

    @Test
    public void test() {
        int[] nums = {1,2,3,4,5};
        System.out.println(CombinationGenerator.count(nums,3));
       // CombinationGenerator.choose(nums,3);
        CombinationGenerator.choose2(nums,3);
    }

}