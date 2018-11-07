package com.common.java;

import java.util.PriorityQueue;
import java.util.Random;

public class PriorityQueueAPI {

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Random rand = new Random();
        for(int i=0;i<20;i++) {
            minHeap.add(rand.nextInt(100));
        }

        for(int i=0;i<20;i++) {
            System.out.println(minHeap.poll());
        }




    }
}
