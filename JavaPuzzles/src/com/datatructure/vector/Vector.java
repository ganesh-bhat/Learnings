package com.datatructure.vector;

import java.util.Arrays;

/**
 * Implement a vector (mutable array with automatic resizing):
 * start with 16, or if starting number is greater, use power of 2 - 16, 32, 64, 128
 *  size() - number of items
 *  capacity() - number of items it can hold
 *  is_empty()
 *  at(index) - returns item at given index, blows up if index out of bounds
 *  push(item)
 *  insert(index, item) - inserts item at index, shifts that index's value and trailing elements to the right
 *  prepend(item) - can use insert above at index 0
 *  pop() - remove from end, return value
 *  delete(index) - delete item at index, shifting all trailing elements left
 *  remove(item) - looks for value and removes index holding it (even if in multiple places)
 *  find(item) - looks for value and returns first index with that value, -1 if not found
 *  resize(new_capacity) // private function
 * when you reach capacity, resize to double the size
 * when popping an item, if size is 1/4 of capacity, resize to half
 */
public class Vector<T> {

    private T[] items;
    private int size;
    private int capacity;

    /**
     *
     * @param capacity
     */
    public Vector(int capacity){
        this.capacity = capacity;
        items = (T[])new Object[capacity];
    }

    /**
     *
     */
    public Vector(){
        capacity = 16;
        items = (T[])new Object[capacity];
    }

    public void push(T item) {
        ensureCapacity();
        items[size++] = item;
    }

    public void insert(int index, T item) {
        if(index<0) throw new ArrayIndexOutOfBoundsException("Unknown index:"+index);
        ensureCapacity(index);

        if(index < size) {
            T[] temp = (T[])new Object[size-index];
            System.arraycopy(items, index,temp,0,(size-index));
            items[index] = item;
            System.arraycopy(temp, 0,items,index+1,(size-index));
        } else {
            Arrays.fill(items,size,index,null);
            items[index] = item;
            size = index;
        }
        size++;
    }

    public void prepend(T item) {
        insert(0,item);
    }

    public T pop() {
        indexBoundsCheck(size-1);
        T deleted = items[size-1];
        items[size-1] = null;
        size--;
        return deleted;
    }

    public T delete(int index) {
        indexBoundsCheck(index);
        if(index == size-1) {
            return pop();
        }
        T deleted = items[index];
        System.arraycopy(items, index,items,index-1,(size-index));
        size--;
        return deleted;
    }

    public boolean find(T item) {
        if(item == null) return false;

        for(T e: items) {
            if(e!=null && e.equals(item)){
                return true;
            }
        }
        return false;
    }

    public boolean remove(T item) {
        boolean isDeleted = false;
        for(int i=0;i<size;i++) {
            T e = items[i];
            if(e.equals(item)){
                delete(i);
                isDeleted = true;
            }
        }
        return isDeleted;
    }

    public void resize(int newSize) {
        T[] newItems = (T[])new Object[newSize];
        int itemsToCopy = size<newSize?size:newSize;
        System.arraycopy(items,0,newItems,0,itemsToCopy);
        items = newItems;
    }

    private void indexBoundsCheck(int index) {
        if(index <0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("unknown index:"+index);
        }
        if(size == 0) {
            throw new ArrayIndexOutOfBoundsException("unknown index:"+index+" size is:"+size);
        }
    }

    public T at(int index) {
        indexBoundsCheck(index);
        return items[index];
    }

    private void ensureCapacity() {
        ensureCapacity(size+1);
    }

    private void ensureCapacity(int index) {
        if(index < 0) {//overflow
            throw new IllegalArgumentException("Cant expand further,reached limit");
        }
        int newCapacity = capacity;
        while(index >= newCapacity) {
            newCapacity = capacity<<1;
        }
        if(newCapacity < 0) {
            //overflow
            newCapacity = Integer.MAX_VALUE;
        }
        if(capacity<newCapacity) {
            resize(newCapacity);
            capacity = newCapacity;
        }
    }


}
