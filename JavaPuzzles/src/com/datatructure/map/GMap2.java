package com.datatructure.map;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class GMap2<K,V> {

    static class Node<K,V> implements Map.Entry<K,V> {

        K key;
        V value;
        int hash;
        Node next;

        @Override
        public K getKey() {
            return null;
        }

        @Override
        public V getValue() {
            return null;
        }

        @Override
        public V setValue(V value) {
            return null;
        }
    }

    transient Node[] items;
    int capacity = 16;
    float loadFactor = 0.75f;
    int treshold = (int)(capacity * loadFactor);
    int size = 0;

    public GMap2(int capacity) {
        this.capacity = capacity;
    }

    public GMap2(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public void put(K key, V value) {
        ensureCapacity();
    }

    private void ensureCapacity() {
        if((size+1)>= treshold) {
            int newCapacity = capacity << 1;
            int newTreshold = (int)(capacity * loadFactor);

            Node[] newItems = Arrays.copyOf(items,newCapacity);

            for(int index=0;index<items.length;index++) {
                if(items[index]!=null) {
                    Node node = items[index];
                    int in = (node.hash % newItems.length);
                    if(node.next == null && newItems[in] == null) {
                        newItems[in] = node;
                    } else {




                    }
                }
            }


        }
    }

   /* public V get(K key) {

    }

    public Set<Map.Entry<K,V>> entrySet() {

    }


    public Set<K> keySet() {

    }*/


}
