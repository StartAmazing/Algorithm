package com.ll.utils;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int data){
        this.val = data;
    }

    public static void printList(ListNode head) {
        ListNode start = head;
        while (start != null) {
            System.out.print(start.val);
            start = start.next;
            if (start != null) {
                System.out.print(" -> ");
            }
        }
    }
}
