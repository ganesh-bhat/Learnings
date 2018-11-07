package com.datatructure.stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class StackReversalWithoutExternalDs {

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        reverseStack(stack);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }

    public static <T> void reverseStack(Deque<T> stack) {
        if (stack.isEmpty()) {
            return;
        }
        // Remove bottom element from stack
        T bottom = popBottom(stack);

        // Reverse everything else in stack
        reverseStack(stack);

        // Add original bottom element to top of stack
        stack.push(bottom);
    }

    private static<T> T popBottom(Deque<T> stack) {
        T top = stack.pop();
        if(stack.isEmpty()) {
            return top;
        }

        T bottom = popBottom(stack);
        stack.push(top);
        return bottom;
    }

}
