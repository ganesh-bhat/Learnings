package com.datatructure.queue;

import com.datatructure.stack.ArrayStack;

public class QueueWithStack<T> {

    private ArrayStack<T> stack1 = new ArrayStack<>();
    private ArrayStack<T> stack2 = new ArrayStack<>();

    public void add(T item) {
        stack1.push(item);
    }

    public T remove() {
        if(!isEmpty()) {
            if(stack2.isEmpty()) {
                while(!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }
            return stack2.pop();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public boolean isEmpty() {
        return ((stack1.size() + stack2.size()) == 0 );
    }


    public void clear() {
        while(!stack2.isEmpty()) {
            stack2.pop();
        }
        while(!stack1.isEmpty()) {
            stack1.pop();
        }

    }

    public int size() {
        return (stack1.size() + stack2.size());
    }
}
