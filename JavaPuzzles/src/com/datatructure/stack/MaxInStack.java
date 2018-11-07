package com.datatructure.stack;

/**
 * get the max in stack with O(1), idea is to maintain a max variable in each node of stack
 *
 * @param <T>
 */
public class MaxInStack<T extends Comparable<T>> {

    class Node<T> {
        T data;
        T max;
        Node<T> next;

        Node(T item, T max, Node<T> next) {
            this.data = item;
            this.next = next;
            this.max = max;
        }
    }

    private transient Node<T> head;


    public void push(T item) {
        if(head ==null) {
            Node node = new Node(item, item,null);
            head = node;
        } else {
            head = new Node(item,max(item,head.max),head);
        }
    }

    private T max(T item1, T item2) {
        return item1.compareTo(item2) > 0?item1:item2;
    }

    public T pop() {
        Node<T> node = head;
        head = head.next;
        return node.data;
    }

    public T max() {
        return head.max;
    }


    public static void main(String[] args) {
        MaxInStack stack = new MaxInStack();
        stack.push(13);
        stack.push(1);
        stack.push(19);
        stack.push(2);
        stack.push(18);
        stack.push(22);
        stack.push(2);

        System.out.println(stack.max());
        stack.pop();
        stack.pop();
        System.out.println(stack.max());
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.max());


    }


}
