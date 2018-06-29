package com.algorithms.search;

import com.algorithms.sorting.MergeSort;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.BinaryOperator;

import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void test() {

        Integer[] numbers = {5,4,2,9,6,3,15,14,8};
        MergeSort.sort(numbers);

        System.out.println(Arrays.toString(numbers));

        BinarySearch.search(numbers,109);

        int index = BinarySearch.search(numbers,6);
        Assert.assertEquals(4, index);

        int index2 = BinarySearch.iterativeSearch(numbers,6);
        Assert.assertEquals(4, index2);


        Assert.assertEquals(BinarySearch.search(numbers,14), BinarySearch.iterativeSearch(numbers,14));
        Assert.assertEquals(BinarySearch.search(numbers,8), BinarySearch.iterativeSearch(numbers,8));
        Assert.assertEquals(BinarySearch.search(numbers,109), BinarySearch.iterativeSearch(numbers,109));
       // Assert.assertEquals(BinarySearch.search(numbers,2), BinarySearch.iterativeSearch(numbers,2));
        //Assert.assertEquals(BinarySearch.search(numbers,-3), BinarySearch.iterativeSearch(numbers,-3));

    }

}