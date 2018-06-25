package com.datatructure.stack;

public class ArrayNStack<T> {

    private Object[] items;

    private int[] startIndex;
    private int[] endIndex;

    public ArrayNStack(int stackCount, int initialCapacity) {
        if(stackCount>initialCapacity) {
            throw new IllegalArgumentException("Stack Count "+stackCount+ "cant be more than initial capacity "+initialCapacity);
        }

        items = new Object[initialCapacity];
    }

    public ArrayNStack(int stackCount) {

        items = new Object[stackCount*16];//16 for each stack
        startIndex = new int[stackCount];
        endIndex = new int[stackCount];

        for(int i=0;i<stackCount;i++) {

        }
    }



}
