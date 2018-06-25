package com.datatructure.stack;

import org.junit.Test;

public class LinkedStackTest {

    @Test
    public void test() {

        LinkedStack<Integer> stack = new LinkedStack<>();
        for(int i=1;i<10;i++) {
            stack.push(i);
        }

        for(int i=1;i<10;i++) {
            System.out.println(stack.pop());
        }


    }
}
