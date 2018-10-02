package com.datatructure.list;

public class ListReversalWithoutStack<T> {

    static class Node<T> {
        Node<T> next;
        T data;

        Node(T data) {
            this.data = data;
        }
    }

    Node<T> head;
    Node<T> tail;

    void insertLast(T data) {
        if(tail == null) {
            tail = new Node(data);
            head = tail;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head;
        while(cur!=null) {
            sb.append(cur.data).append(" ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public void reverse() {
        Node<T> cur = null;
        Node<T> prev = null;
        Node<T> next = null;

        tail = head;

        cur = head;
        while (cur!=null) {
            //backup next
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        head = prev;
    }

    public void reverse(int k) {
        head = reverse(head,k);
    }

    /* reverse nodes in group of k */
    public Node<T> reverse(Node<T> root, int k) {

        int count = 1;
        Node<T> cur = null;
        Node<T> prev = null;
        Node<T> next = null;

        cur = root;

        while (cur!=null && count<=k) {
            //backup next
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count++;
        }

        if(next!=null) {
            head.next = reverse(next, k);
        }

        return prev;

    }

    public static void main(String[] args) {
        ListReversalWithoutStack<Integer> list = new ListReversalWithoutStack<>();
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);

        System.out.println(list);
        list.reverse();

        System.out.println(list);

        list.reverse(2);

        System.out.println(list);

    }

}
