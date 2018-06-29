package com.algorithms.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MinHeapTest {

    @Test
    public void test() {
        MinHeap heap = new MinHeap();
        heap.add(6);
        heap.add(11);
        heap.add(3);
        heap.add(1);
        heap.add(14);

        for(int val: IntStream.range(18,25).toArray()) {
            heap.add(val);
        }

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());



    }
}