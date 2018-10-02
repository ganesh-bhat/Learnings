package com.datatructure.list;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapNodesInPairsTest {

    @Test
    public void swapPairs() {
        SwapNodesInPairs.ListNode head =  node(1, node(2, node(3, node(4, null))));
        new SwapNodesInPairs().print(head);
        head = new SwapNodesInPairs().swapPairs(head);
        new SwapNodesInPairs().print(head);
    }

    @Test
    public void swapPairs2() {
        SwapNodesInPairs.ListNode head =  node(1, node(2, node(3, null)));
        new SwapNodesInPairs().print(head);
        head = new SwapNodesInPairs().swapPairs(head);
        new SwapNodesInPairs().print(head);
    }


    private SwapNodesInPairs.ListNode node (int data, SwapNodesInPairs.ListNode next) {
        SwapNodesInPairs.ListNode node = new SwapNodesInPairs.ListNode(data);
        node.next = next;
        return node;
    }
}