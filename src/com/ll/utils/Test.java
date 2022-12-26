package com.ll.utils;

import java.util.List;

public class Test {


    public static ListNode reOrderList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 1. split
        ListNode postList = split(head);

        // 2. reverse
        ListNode reversedList = reverse(postList);

        // 3. combine
        return combineList(head, reversedList);
    }

    private static ListNode split(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode res = slow.next;
        slow.next = null;

        return res;
    }

    private static ListNode reverse(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode, curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }

        head.next = null;

        return preNode;
    }

    private static ListNode combineList(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode cur = res;
        ListNode cur1 = l1, cur2 = l2;
        while (cur1 != null && cur2 != null) {
            ListNode next1 = cur1.next;
            ListNode next2 = cur2.next;
            cur.next = cur1;
            cur = cur.next;
            cur.next = cur2;
            cur = cur.next;
            cur1 = next1;
            cur2 = next2;
        }

        if (cur1 != null) {
            cur.next = cur1;
        }

        if (cur2 != null) {
            cur.next = cur2;
        }

        return res.next;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);

        ListNode.printList(head);
        System.out.println();
        ListNode.printList(reOrderList(head));
    }
}
