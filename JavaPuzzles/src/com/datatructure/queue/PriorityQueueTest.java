package com.datatructure.queue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PriorityQueueTest {

    @Test
    public void offer() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(4);
        queue.offer(5);
        queue.offer(8);
        queue.offer(11);
        queue.offer(3);
        queue.offer(26);
        queue.offer(1);

        for(int i=0;i<7;i++) {
            System.out.println(queue.poll());
        }

    }

    @Test
    public void offer2() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.offer(4);
        queue.offer(1);
        queue.offer(5);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());


    }

    @Test
    public void testEnsureCapacity() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=1;i<=50;i++) {
            queue.offer(i);
        }

        for(int i=50;i>0;i--) {
            int data = queue.poll();
            Assert.assertEquals(i,data );
            System.out.println(data);

        }

    }
}