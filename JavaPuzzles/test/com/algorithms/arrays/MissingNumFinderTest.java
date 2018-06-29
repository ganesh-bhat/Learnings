package com.algorithms.arrays;

import org.junit.Test;

import static org.junit.Assert.*;

public class MissingNumFinderTest {

    @Test
    public void findMissingNumber() {

        int missing = MissingNumFinder.findMissingNumber(new int[]{1,2,3,4,5,6,7,8,10}, 10);
        System.out.println(missing);

        missing = MissingNumFinder.findMissingNumber(new int[]{3,10,5,8,1,6,7,4,2}, 10);
        System.out.println(missing);
    }
}