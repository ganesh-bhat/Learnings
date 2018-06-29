package com.algorithms.sorting;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void quickSort() {
        Integer[] numbers = {5,4,2,9,6,3,15,14,8};
        QuickSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));

    }
}