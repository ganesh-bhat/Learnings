package com.algorithms.sorting;

import com.sun.xml.internal.bind.v2.model.annotation.Quick;
import org.junit.Test;

import java.util.Arrays;

public class QuickSortTest {

    @Test
    public void quickSort() {
        Integer[] numbers = {5,8,1,2,3,6};
        QuickSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));

    }
}