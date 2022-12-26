package com.ll;

import com.ll.utils.ListNode;

public class DebugTest {

    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null) {
            return head;
        }

        // 1. find mth & nth node and their pre;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = head, preNode = dummyNode;
        ListNode mNode = null, mPreNode = null, nNode = null, nNodeNext = null;
        int i = 1;
        while(i < m) {
            i++;
            curNode = curNode.next;
            preNode = preNode.next;
        }

        mNode = curNode;
        mPreNode = preNode;

        while(i < n) {
            i++;
            curNode = curNode.next;
            preNode = preNode.next;
        }

        nNode = curNode;
        nNodeNext = curNode.next;

        nNode = reverseNode(mNode, nNodeNext);

        mPreNode.next = nNode;

        curNode = nNode;
        while(curNode != null) {
            mPreNode = mPreNode.next;
            curNode = curNode.next;
        }

        mPreNode.next = nNodeNext;

        return dummyNode.next;

    }

    private static ListNode reverseNode(ListNode startNode, ListNode endNode) {
        ListNode curNode = startNode.next;
        ListNode preNode = startNode;
        while(curNode != endNode) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }

        startNode.next = null;

        return preNode;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next  = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode node = reverseBetween(head, 1, 4);

    }
}
