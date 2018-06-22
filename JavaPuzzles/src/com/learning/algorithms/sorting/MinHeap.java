package com.learning.algorithms.sorting;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by ganes on 09-06-2018.
 * https://www.youtube.com/watch?v=t0Cq6tVNRBA
 *
 *
 */
public class MinHeap {

    public static void main(String[] args) {
        MinHeap heap = new MinHeap();
        heap.add(6);
        heap.add(11);
        heap.add(3);
        heap.add(1);
        heap.add(14);

        for(int val:IntStream.range(18,25).toArray()) {
            heap.add(val);
        }

        System.out.println(Arrays.toString(heap.items));

        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());
        System.out.println(heap.poll());



    }


    int size = 0;
    int capacity = 16;
    private int[] items = new int[capacity];

    /* utility methods */
    private int getParentIdx(int index) {
        return (index - 1)/2;
    }

    private int getLeftChildIdx(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIdx(int index) {
        return 2 * index + 2;
    }

    private boolean hasLeftChild(int index) {
        return (getLeftChildIdx(index) < size);

    }

    private int getLeftChild(int index) {
        return items[getLeftChildIdx(index)];
    }

    private int getRightChild(int index) {
        return items[getRightChildIdx(index)];

    }

    private int getParent(int index) {
        return items[getParentIdx(index)];
    }


    private boolean hasRightChild(int index) {
        return (getRightChildIdx(index) < items.length);
    }

    private boolean hasParent(int index) {
        return (getParentIdx(index)>= 0);
    }

    private void swap(int idx1, int idx2) {
        int temp = items[idx1];
        items[idx1] = items[idx2];
        items[idx2] = temp;
    }

    private void ensureCapacity() {
        if(size == capacity) {
            capacity = items.length*2;
            items = Arrays.copyOf(items, capacity);
        }
    }

    /* operations*/
    private int peek() {
        return items[0];
    }

    private int poll() {
        int result = items[0];
        items[0] = items[size-1];
        size--;
        heapifyDown();
        return result;
    }

   

    private void add(int num ) {
        ensureCapacity();
        items[size] = num;
        size++;
        heapifyUp();
    }

    private void  heapifyUp() {

        int index = size-1;//last item inserted
        while( hasParent(index) && getParent(index) > items[index]) {
            swap(getParentIdx(index),index);
            index = getParentIdx(index);
        }
    }

    private void heapifyDown() {
        int index = 0;
        while(hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIdx(index);
            if(hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIdx(index);
            }

            if(items[index]<items[smallerChildIndex]) {
                break;
            } else {
                swap(index,smallerChildIndex);
            }
            index = smallerChildIndex;
        }



    }


    
    
    



}
