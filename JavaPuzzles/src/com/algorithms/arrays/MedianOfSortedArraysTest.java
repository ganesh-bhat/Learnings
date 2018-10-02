package com.algorithms.arrays;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MedianOfSortedArraysTest {

    @Test
    public void median() {
       float res = MedianOfSortedArrays.median(new int[]{},new int[]{});
        System.out.println(res);

        //1,2,3,4,5,6,8,9,11,14
        res = MedianOfSortedArrays.median(new int[]{1,2,4,5,8},new int[]{3,6,9,11,14});
        System.out.println(res);

        //1,2,3,4,5,6,8,9,10,11,14
        res = MedianOfSortedArrays.median(new int[]{1,2,4,5,8,10},new int[]{3,6,9,11,14});
        System.out.println(res);

    }
}