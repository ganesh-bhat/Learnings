package com.datatructure.queue;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * Based on heap data structure
 */
public class PriorityQueue<T extends Comparable<T>> {

    private Object[] items;
    private int capacity = 16;
    private int size = 0;
    private Comparator comparator;

    public PriorityQueue(){
        init();
    }

    public PriorityQueue(Comparator<T> comparator) {
        this.comparator = comparator;
        init();
    }

    private void init() {
        items = new Object[capacity];
    }

    public void offer(T item){
        ensureCapacity();
        items[size++] = item;
        heapifyUp();
    }

    private void heapifyUp() {
        int n = size-1;
        while(n>0 && compare(parent(n),items[n])<0) {
            swap(parentIndex(n), n);
            n = parentIndex(n);
        }
    }

    public T poll(){
        Object item = items[0];
        items[0] = items[--size];
        heapifyDown();
        //reduce array size after some %??
        return (T)item;
    }

    private void heapifyDown() {
        int n = 0;
        while(n<size && leftChildIndex(n) < size &&
                ( compare(leftChild(n),items[n])> 0 || compare(rightChild(n),items[n])> 0)) {

                int biggestChildIndex = leftChildIndex(n);
                if(rightChildIndex(n) < size && compare(items[biggestChildIndex],rightChild(n))<0) {
                    biggestChildIndex = rightChildIndex(n);
                }
                swap(biggestChildIndex,n);
                n = biggestChildIndex;
        }
    }


    private void ensureCapacity() {
        if(size == capacity) {
            int newCapacity = capacity <<1;
            items = Arrays.copyOf(items, newCapacity);
            capacity = newCapacity;
        }
    }


    //util methods
    private int leftChildIndex(int n) {
        return 2*n+1;
    }

    private int rightChildIndex(int n) {
        return 2*n+2;
    }

    private int parentIndex(int n) {
        return (n-1)/2;
    }

    private T leftChild(int n) {
        return (T)items[leftChildIndex(n)];
    }

    private T rightChild(int n) {
        return (T)items[rightChildIndex(n)];
    }

    private T parent(int n) {
        return (T)items[parentIndex(n)];
    }

    private void swap(int n, int m) {
        Object temp = items[n];
        items[n] = items[m];
        items[m] = temp;
    }

    private int compare(Object parent, Object item) {
        if(comparator!=null) {
            return comparator.compare(parent, item);
        } else {
            if(parent!=null && item!=null) {
                return ((Comparable)parent).compareTo((Comparable)item);
            } else if(parent == null && item == null) {
                return 0;
            } else if(parent!=null) {
                return 1;
            }
            return -1;
        }
    }
}
