package com.datatructure.stack;

import org.junit.Test;

public class ArrayStackTest {

    @Test
    public void test() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        for(int i=1;i<50;i++) {
            stack.push(i);
        }

        for(int i=1;i<50;i++) {
            System.out.print(stack.pop());
        }
    }

    @Test
    public void capacityExpansion() {
        ArrayStack<Integer> stack = new ArrayStack<>(3,false);
        for(int i=1;i<50;i++) {
            stack.push(i);
        }

        for(int i=1;i<50;i++) {
            System.out.print(stack.pop());
        }
    }


    @Test
    public void fixedCapacity() {
        ArrayStack<Integer> stack = new ArrayStack<>(3,false);
        for(int i=1;i<50;i++) {
            stack.push(i);
        }

        for(int i=1;i<50;i++) {
            System.out.print(stack.pop());
        }
    }
}
