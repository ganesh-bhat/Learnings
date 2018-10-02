package com.datatructure.queue;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueTest {

    @Test
    public void test1() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        for(int i=0;i<20;i++) {
            queue.offer(i);
        }

        Assert.assertEquals(queue.size(), 20 );

        for(int i=0;i<20;i++) {
            Assert.assertEquals(i,(int)queue.poll());
        }

        Assert.assertTrue(queue.isEmpty());

        Assert.assertNull(queue.poll());

    }

    @Test
    public void test2() {
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        for(int i=0;i<10;i++) {
            queue.offer(i);
        }
        Assert.assertEquals(queue.size(), 10 );
        for(int i=0;i<5;i++) {
            Assert.assertEquals(i,(int)queue.poll());
        }
        Assert.assertEquals(queue.size(), 5 );

        for(int i=10;i<15;i++) {
            queue.offer(i);
        }
        Assert.assertEquals(queue.size(), 10 );

        for(int i=5;i<15;i++) {
            Assert.assertEquals(i,(int)queue.poll());
        }

        Assert.assertTrue(queue.isEmpty());

        Assert.assertNull(queue.poll());

    }




}