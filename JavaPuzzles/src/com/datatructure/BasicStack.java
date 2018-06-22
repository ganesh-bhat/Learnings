package com.datatructure;

public class BasicStack<T> {

    class Node<T> {
        T data;
        Node<T> next;

        Node(T item, Node<T> next) {
            this.data = item;
            this.next = next;
        }
    }

    Node<T> head;


    public void push(T item) {
        if(head ==null) {
            Node node = new Node(item, null);
            head = node;
        } else {
            head = new Node(item,head);
        }
    }

    public T pop() {
        Node<T> node = head;
        head = head.next;
        return node.data;
    }

}
