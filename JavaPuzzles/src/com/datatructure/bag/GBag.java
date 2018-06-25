package com.datatructure.bag;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by ganes on 21-06-2018.
 */
public class GBag<Item> implements Iterable<Item> {

    private static final int MAX_CAPACITY = Integer.MAX_VALUE;
    private transient Object[] items = {};
    private int capacity = 16;
    private int size = 0;

    public GBag(int capacity) {
        if (capacity > MAX_CAPACITY) {
            capacity = MAX_CAPACITY;
        }
        init();

    }

    public GBag() {
        //allow creation without params as well
        init();
    }

    private void init() {
        items = new Object[capacity];
    }


    public int size() {
        return size;
    }

    public void add(Item item) {
        ensureCapacity();
        items[size++] = item;

    }

    private void ensureCapacity() {
        System.out.println("capacity:" + capacity + " items:" + items.length);
        System.out.println("size:" + size);
        if ((size + 1) >= capacity) {
            if ((size + 1) > MAX_CAPACITY) {
                throw new OutOfMemoryError();
            }

            int newCapacity = capacity + (capacity >> 1);

            if (newCapacity > MAX_CAPACITY) {
                newCapacity = MAX_CAPACITY;
            }
            items = Arrays.copyOf(items, newCapacity);
            capacity = newCapacity;
            System.out.println("Resized array to newCapacity:" + newCapacity + " newTab:" + items.length);
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return new BagIterator();
    }

    class BagIterator implements Iterator<Item> {

        int index = 0;

        @Override
        public boolean hasNext() {
            return (index < size);
        }

        @Override
        public Item next() {
            if (hasNext()) {
                return (Item) items[index++];
            }
            throw new IndexOutOfBoundsException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

}
