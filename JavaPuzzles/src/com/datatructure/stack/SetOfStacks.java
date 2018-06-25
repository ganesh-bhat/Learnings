package com.datatructure.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * set of plates over many small groups of items ( stacks )
 */
public class SetOfStacks<T> {

    private List<ArrayStack<T>> stackSet = new ArrayList<>();

    private ArrayStack<T> currentStack;

    private int eachStackCapacity = 16;

    private int size = 0;

    public SetOfStacks(int eachStackCapacity) {
        this.eachStackCapacity = eachStackCapacity;
    }

    public int size() {
        return size;
    }

    public void push(T item) {
        if(currentStack == null && stackSet.isEmpty()) {
            currentStack = new ArrayStack<>(eachStackCapacity, true);
            stackSet.add(currentStack);
        } else {
            if(currentStack.isFull()) {
                currentStack = new ArrayStack<>(eachStackCapacity, true);
                stackSet.add(currentStack);
            }
        }
        currentStack.push(item);
        size++;
    }

    public T pop() {
        if(currentStack.isEmpty()) {
            if(!stackSet.isEmpty()) {
                stackSet.remove(stackSet.size()-1);
                if(!stackSet.isEmpty()) {
                    currentStack = stackSet.get(stackSet.size()-1);
                } else {
                    currentStack = null;
                }
            }
        }

        if(currentStack !=null) {
            T item = currentStack.pop();
            return item;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public boolean isEmpty() {
        return currentStack == null;
    }

}
