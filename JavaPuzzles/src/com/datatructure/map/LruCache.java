package com.datatructure.map;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ganes on 20-06-2018.
 */
public class LruCache<K extends Comparable,V> {
    private static class Node<K,V> {
        K key;
        V data;
        Node next;
        Node prev;

        Node(K key, V value) {
            this.key = key;
            this.data = value;
        }
    }

    private int mCapacity;
    private transient Map<K,Node<K,V>> lookupMap;
    private transient Node<K,V> head;
    private transient Node<K,V> tail;
    private int size;


    public LruCache(int capacity) {
        mCapacity = capacity;
        lookupMap = new HashMap<>(capacity);
    }

    public void add(K key, V value) {
        if(lookupMap.containsKey(key)) {
            Node<K,V> node = lookupMap.get(key);
            node.data = value;
            removeNode(node);
            addNode(node);
        } else {
            Node<K,V> node = new Node<K,V>(key,value);
            addNode(node);
            lookupMap.put(key,node);
            size++;
            if(size> mCapacity) {
                K oldKey = removeNode();
                lookupMap.remove(oldKey);
            }
        }
    }

    public V get(K key) {
        V data = null;
        if(lookupMap.containsKey(key)) {
            Node<K,V> node = lookupMap.get(key);
            data = node.data;
            removeNode(node);
            addNode(node);
        }
        return data;
    }

    private void removeNode(Node<K,V> node) {
        Node<K,V> prev = node.prev;
        Node<K,V> next = node.next;

        if(prev!=null) {
            prev.next = next;
            if(next!=null) {
                next.prev = prev;
            } else {
                tail = prev;
            }
        } else if(next!=null){
            head = next;
        } else {
            head = null;
            tail = null;
        }
    }

    private K removeNode() {
        K key = null;
        if(tail!=null) {
            key = tail.key;
            tail = tail.prev;
            if(tail!=null) {
                tail.next = null;
            }
        }
        return key;
    }

    private void addNode(Node<K,V> node) {
        if(head == null && tail == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}
