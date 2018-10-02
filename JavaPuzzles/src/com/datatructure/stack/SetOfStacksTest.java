package com.datatructure.stack;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SetOfStacksTest {

    SetOfStacks<Integer> setOfStacks = new SetOfStacks(2);

    @Before
    public void setUp() throws Exception {



    }

    @Test
    public void push() {
        for(int i=0;i<30;i++) {
            setOfStacks.push(i);
        }

        Assert.assertEquals(30,setOfStacks.size());
    }

    @Test
    public void pop() {
        for(int i=0;i<=100;i++) {
            setOfStacks.push(i);
        }
        for(int i=100;i>=0;i--) {
            int x = setOfStacks.pop();
            Assert.assertEquals(x,i);
        }
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void popException() {
        for(int i=0;i<=10;i++) {
            setOfStacks.push(i);
        }
        for(int i=15;i>=0;i--) {
            int x = setOfStacks.pop();
        }
    }

    @Test
    public void isEmpty() {
        Assert.assertTrue(setOfStacks.isEmpty());
        setOfStacks.push(2);
        Assert.assertFalse(setOfStacks.isEmpty());
    }




}