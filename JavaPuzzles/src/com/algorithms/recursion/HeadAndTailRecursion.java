package com.algorithms.recursion;

/**
 * head and tail recursion and linked list, reversal
 */
public class HeadAndTailRecursion {

    static class MyList<T> {
        Node head;
        Node tail;

        public void add(T item) {
            Node node = new Node(item);
            if(head == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                tail = node;
            }
        }

        public void reverse() {
            Node current = head;
            Node temp;
            Node prev = null;

            while(current!=null) {
                temp = current.next;
                current.next = prev;
                prev = current;
                current = temp;
            }

            tail = head;
            head = prev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder("[ ");
            Node temp = head;
            while(temp!=null) {
                sb.append(temp.data + " ");
                temp = temp.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }
    static class Node<T> {
        Node next;
        T data;

        Node(T t) {
            data = t;
        }
    }


    public static void main(String[] args) {
        MyList<Integer> list = new MyList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        System.out.println(list);
        list.reverse();
        System.out.println(list);

        headRecurseTraverse(list.head);
        System.out.println("");
        tailRecurseTraverse(list.head);
        System.out.println("");


    }

    static void headRecurseTraverse(Node node) {
        if(node == null) {return;}
        System.out.print(node.data + " ");
        headRecurseTraverse(node.next);
    }

    static void tailRecurseTraverse(Node node) {
        if(node == null) {return;}
        tailRecurseTraverse(node.next);
        System.out.print(node.data + " ");
    }


}
