package com.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeSortTest {

    @Test
    public void sort() {

        Integer[] numbers = {5,4,2,9,6,3,15,14,8};
        MergeSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));
    }
}