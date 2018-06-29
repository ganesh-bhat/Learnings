package com.datatructure.map;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

//ideally implement Map interface and provide entrySet, keySet
public class GMap2<K, V> {

    transient private Node<K,V>[] items;
    private int capacity = 16;
    private float loadFactor = 0.75f;
    int size = 0;

    public GMap2(int capacity, float loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
    }

    public GMap2() {
        init();
    }

    private void init() {
        items = new Node[capacity];
    }

    public V put(K key, V value){
        ensureCapacity();
        V oldValue = null;
        int index = 0;
        int hashCode = 0;
        if(key != null) {
            hashCode = key.hashCode();
            index = hashCode % capacity;
        }
        if(items[index]==null) {
            items[index] = new Node(hashCode, key, value);
        } else {

            Node<K,V> currentNode = items[index];
            while(currentNode!=null) {
                if((currentNode.key!=null && currentNode.key.equals(key)) || (currentNode.key == key)) {
                    oldValue = currentNode.getValue();
                    currentNode.setValue(value);
                    break;
                }
                currentNode = currentNode.next;
            }

            if(currentNode == null) {
                items[index] = new Node(hashCode, key, value, currentNode);
            }
        }
        size++;
        return oldValue;
    }

    public V get(K key) {
        V value = null;
        int index = 0;
        int hashCode = 0;
        if(key != null) {
            hashCode = key.hashCode();
            index = hashCode % capacity;
        }

        Node<K,V> currentNode = items[index];
        while(currentNode!=null) {
            if((currentNode.key!=null && currentNode.key.equals(key)) || (currentNode.key == key)) {
                value = currentNode.getValue();
               break;
            }
            currentNode = currentNode.next;
        }
        size--;
        return value;
    }


    private void ensureCapacity() {
        //check load factory and size
        if(loadFactor*capacity <= size) {
            int newCapacity = capacity << 1;
            Node<K,V>[] newItems = new Node[newCapacity];

            for(int i=0;i<capacity;i++) {
                Node<K,V> item = items[i];
                Node<K,V> next;
                while(item!=null) {
                    if(item.hash == 0 && item.key!=null) {
                        item.hash = item.key.hashCode();
                    }
                    int newIndex = item.hash % newCapacity;
                    next = item.next;//keep backup

                    if(newItems[newIndex]!=null) {
                        Node<K,V> existingNode = newItems[newIndex];
                        item.next = existingNode;
                        newItems[newIndex] = item;
                    } else {
                        item.next = null;
                        newItems[newIndex] = item;
                    }
                    item = next;
                }

            }

            capacity = newCapacity;
            items = newItems;
        }
    }



    static class Node<K,V> implements Map.Entry<K,V> {

        int hash;
        K key;
        V value;
        Node<K,V> next;

        Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = null;
        }

        Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V oldValue = this.value;
           this.value = value;
           return oldValue;
        }
    }

}
