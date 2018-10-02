package com.datatructure.stack;

import com.datatructure.queue.QueueWithStack;
import org.junit.Assert;
import org.junit.Test;

public class QueueWithStackTest {

    QueueWithStack<Integer> queue = new QueueWithStack<>();

    @Test
    public void add() {
        for(int i=1;i<=10;i++) {
            queue.add(i);
        }

        Assert.assertEquals(queue.size(),10);

    }

    @Test
    public void remove() {
        queue.clear();
        for(int i=1;i<=10;i++) {
            queue.add(i);
        }

        for(int i=1;i<=10;i++) {
            int x = queue.remove();
            Assert.assertEquals(i,x);
        }


    }

    @Test
    public void isEmpty() {
        for(int i=1;i<=10;i++) {
            queue.add(i);
        }

        for(int i=1;i<=10;i++) {
            int x = queue.remove();

        }

        Assert.assertTrue(queue.isEmpty());
    }
}