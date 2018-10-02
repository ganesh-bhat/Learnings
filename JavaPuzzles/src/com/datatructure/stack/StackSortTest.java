package com.datatructure.stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class StackSortTest {

    @Test
    public void sort() {

        StackSort sorter = new StackSort();

        int[] num = {5,8,6,2,1,3,4,7};
        sorter.sort(num);

        System.out.println(Arrays.toString(num));

        for(int i=0;i<8;i++) {
            Assert.assertEquals((i+1), num[i]);
        }

    }
}