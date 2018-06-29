package com.datatructure.queue;

public class LinkedQueue<V> {

    private static class Node<T> {
        Node<T> next;
        Node<T> prev;
        T data;

        Node(T value) {
            this.data = value;
        }
    }

    private Node<V> head;
    private Node<V> tail;
    private int size;


    public void offer(V value) {
        Node node = new Node(value);
        if(head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    public V poll() {
        V data = null;
        if(tail != null) {
            data = tail.data;
            tail = tail.prev;
            if(tail!=null) {
                tail.next = null;
            }
            size--;
        }
        return data;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
