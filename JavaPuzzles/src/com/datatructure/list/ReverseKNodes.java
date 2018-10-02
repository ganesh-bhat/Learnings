package com.datatructure.list;

import java.util.List;
import java.util.Stack;

public class ReverseKNodes {

    static class Node{
        int data;
        Node next;

        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(int data) {
            this.data = data;
        }
    }

    Node head;

    ReverseKNodes(List<Integer> nodesData) {
        Node node = null;
        Node tail = null;
        for(int i=0;i<nodesData.size();i++) {
            node = new Node(nodesData.get(i));
            if(head == null) {
                head = node;
                tail = head;
            } else {
                tail.next = node;
                tail = node;
            }
        }
    }


    public void reverseNodes(int k) {
        Node cur = head;
        Stack<Node> stack = new Stack<>();

        Node newHead = null;

        while(cur!=null) {
            boolean capturedLastNode = false;
            Node lastNodeNext = null;
            Node newTail = null;

            int i;
            for(i=1;i<=k && cur!=null;i++) {
                stack.push(cur);
                cur = cur.next;
            }
            if(i==k+1) {
                //got all k nodes
                while(!stack.isEmpty()) {
                    Node node = stack.pop();
                    if(!capturedLastNode) {
                        lastNodeNext = node.next;
                        capturedLastNode = true;
                    }
                    if(newHead == null) {
                        newHead = node;
                    }

                    if(newTail == null ) {
                        newTail = node;
                    } else {
                        newTail.next = node;
                        newTail = node;
                    }
                }
                //set the next pointer correctly
                newTail.next = lastNodeNext;
                cur = lastNodeNext;
            } else {
                stack.clear();
            }
        }

        head = newHead;

    }

    public void print() {
        Node cur = head;
        while(cur!=null) {
            System.out.print(cur.data+"-");
            cur = cur.next;
        }
        System.out.println("||");
    }




}


