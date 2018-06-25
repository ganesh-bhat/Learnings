package com.datatructure.list;

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
    Node<T> root;
    Node<T> head;

    public void add(T value) {
        if(root == null)
        {
            root = new Node(value);
            head = root;
        } else {
            head.next = new Node(value);
            head = head.next;
        }

    }

    public void print() {
        Node current = root;
        while (current!=null) {
            System.out.println(current.value);
            current = current.next;
        }
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


    }
}
