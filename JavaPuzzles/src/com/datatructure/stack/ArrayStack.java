package com.datatructure.stack;

import java.util.Arrays;

public class ArrayStack<T> {
    private static final int MAX_CAPACITY = Integer.MAX_VALUE;
    private final boolean isFixedCapacity;

    private Object[] items;
    int capacity = 5;
    int end = 0;
    int size = 0;

    public ArrayStack() {
        items = new Object[capacity];
        isFixedCapacity = false;
    }

    public ArrayStack(int capacity, boolean isFixedCapacity) {
        this.capacity = capacity;
        items = new Object[this.capacity];
        this.isFixedCapacity = isFixedCapacity;
    }


    public void push(T item) {
        ensureCapacity();
        if(capacity <= (end)) {
          throw new ArrayIndexOutOfBoundsException();
        }
        items[(end++)] = item;
        size++;
    }

    public T pop() {
        if((end-1) < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        size --;
        return (T)items[(--end)];
    }



    private void ensureCapacity() {
        if(!isFixedCapacity) {
            if(end == capacity) {
                int newCapacity = capacity << 1;
                if(newCapacity < 0) {//overflow
                    if(capacity < MAX_CAPACITY) {
                        capacity = MAX_CAPACITY;
                    } else {
                        throw new ArrayIndexOutOfBoundsException();
                    }
                } else {
                    capacity = newCapacity;
                }
                items = Arrays.copyOf(items,capacity);
            }
        }

    }


    public boolean isFull() {
        return isFixedCapacity && (end >= capacity);
    }

    public boolean isEmpty() {
        return (end-1) < 0;
    }

    public int size() {
        return size;
    }

    public T peek() {
       return (T)items[(end-1)];
    }
}
