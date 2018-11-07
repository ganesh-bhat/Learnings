package com.datatructure.list;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next = cur.next;
        ListNode temp = next.next;

        while (cur!=null && next!=null){
             //swap
            cur.next = temp;
            next.next = cur;
            if(prev==null) {
                head = next;
            } else {
                prev.next = next;
            }


            //move
            prev = cur;
            cur = temp;
            if(cur!=null) {
                next = cur.next;
            }
            if(next!=null) {
                temp = next.next;
            }

        }

        return  head;
    }

    public void print(ListNode head) {

        while(head!=null) {
            System.out.print(head.val+"-");
            head = head.next;
        }
        System.out.print("||");
        System.out.println();
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
