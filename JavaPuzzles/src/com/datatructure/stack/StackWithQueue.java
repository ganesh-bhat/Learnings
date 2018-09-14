package com.datatructure.stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue<E> {

    Queue<E> master = new LinkedList<>();
    Queue<E> slave = new LinkedList<>();


    public void push(E item) {
        master.offer(item);
    }

    public E pop() {
        if(master.isEmpty()) return null;

        while(master.size() > 1) {
            slave.offer(master.poll());
        }
        E item = master.poll();
        Queue<E> temp = master;
        master = slave;
        slave = temp;

        return item;
    }

    public boolean isEmpty() {
        return master.isEmpty() && slave.isEmpty();
    }


     public static void main(String[] args) {
         StackWithQueue<Integer> stack = new StackWithQueue<>();
         for(int i=0;i<20;i++) stack.push(i);

         for(int i=0;i<20;i++) System.out.println(stack.pop());

      }
}
