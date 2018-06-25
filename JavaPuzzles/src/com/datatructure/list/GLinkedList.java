package com.datatructure.list;

import java.util.Arrays;
import java.util.Iterator;

/**
 * List with a1->a2>-a3-b1-b2-b3; weave it as a1->b1->a2->b2..
 * list size is even
 */
public class GLinkedList<Item> implements Iterable<Item>{

    public int size() {
        return size;
    }

    class Node<T> {
        Node next;
        T data;

        Node(T data) {
            this.data=data;
        }
    }

    Node<Item> head;
    Node<Item> tail;
    int size;

    public void insertAtEnd(Item data) {
        if(head == null) {
            head  = new Node(data);
            tail = head;
        } else {
            tail.next = new Node(data);
            tail = tail.next;
        }
        size++;
    }

    public void insertAtStart(Item data) {
        if(head == null) {
            head  = new Node(data);
            tail = head;
        } else {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }
        size++;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<Item> temp = head;
        while(temp!=null) {
            sb.append(temp.data);
            if(temp.next == null) {
                sb.append("-|");
            } else {
                sb.append("->");
            }
            temp = temp.next;
        }
        return sb.toString();
    }



    public Item[] getLastElements(int count) {
        if(count <=0) {
            return (Item[])new Object[0];
        }
        if(count> size) {
            throw new IllegalArgumentException();
        }

        int ct = count;
        Node<Item> p2 = head;
        while(p2!=null && ct > 0) {
            p2 = p2.next;
            ct --;
        }
        Node<Item> p1 = head;
        while(p2!=null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        Item[] items = (Item[])new Object[count];
        int i =0;

        while(p1!=null) {
            items[i++] = p1.data;
            p1 = p1.next;
        }
        return items;
    }



    public void weaveList() {
            Node<Item> p1 = head;
            Node<Item> p2 = head;

            while(p1!=null) {
                if(p1.next!=null) {
                    p1 = p1.next.next;
                }
                p2 = p2.next;
            }
            System.out.println(p2.data);

            p1 = head;

            Node<Item> temp1 = null;
            Node<Item> temp2 = null;
            Node<Item> cur = null;
            Node<Item> resetPoint = p2;


            while(p2!=null) {
                cur = p1;
                temp1 = p1.next;
                temp2 = p2;

                p2 = p2.next;
                p1 = p1.next;

                if(temp1 == resetPoint) {//terminal
                    temp1 = null;
                }


                temp2.next = temp1;
                cur.next = temp2;
            }
        }

        public Iterator<Item> iterator() {
            return new GListIterator();
        }

        class GListIterator implements Iterator<Item>{

            Node<Item> node = head;
            @Override
            public boolean hasNext() {
                return node!=null;
            }

            @Override
            public Item next() {
                Item result = null;
                if(hasNext()) {
                    result = node.data;
                    node = node.next;
                } else {
                    throw new IndexOutOfBoundsException();
                }
                return result;

            }
        }
}
