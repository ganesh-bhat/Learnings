package com.datatructure.list;

import java.util.ArrayDeque;

/**
 * Created by ganes on 10-06-2018.
 */
public class LinkedListReversal<T> {

    static class Node<T> {
        T value;
        Node next;

        Node(T value) {
            this.value = value;
        }
    }

    private Node<T> head;
    private Node<T> tail;

    public void add(T value) {
        if(head == null)
        {
            head = new Node(value);
            tail = head;
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }

    }

    public void print() {
        Node current = head;
        while (current!=null) {
            System.out.println(current.value);
            current = current.next;
        }

        System.out.println("-- done printing --");
    }

    public static void main(String[] args) {
        LinkedListReversal list = new LinkedListReversal();
        list.add(10);
        list.add(5);
        list.add(8);
        list.add(15);
        list.add(9);
        list.add(78);

        list.print();

        list.reverse();
        list.print();

    }

    private void reverse() {
        ArrayDeque<Node<T>> stack = new ArrayDeque<>();

        Node<T> node = head;
        while(node!=null) {
            stack.push(node);
            node = node.next;
        }
        tail = null;
        head = null;
        while(!stack.isEmpty()) {
            node = stack.pop();
            node.next = null;
            if(head == null) {
                head = node;
            }
            if(tail!=null) {
                tail.next = node;
            }
            tail = node;
        }
    }
}
