package com.ll.leetcode;

/**
 * Created by LL on 2019/9/26.
 */
public class MergeTwoSortedList_21 {

    private static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    private static Node mergeTwoSortedList(Node n1, Node n2) {
        Node resn = new Node(0);
        Node head = resn;
        Node cur1 = n1;
        Node cur2 = n2;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                head.next = cur1;
                head = head.next;
                cur1 = cur1.next;
            } else {
                head.next = cur2;
                head = head.next;
                cur2 = cur2.next;
            }
        }
        while (cur1 != null) {
            head.next = cur1;
            head = head.next;
            cur1 = cur1.next;
        }
        while (cur2 != null) {
            head.next = cur2;
            head = head.next;
            cur2 = cur2.next;
        }

        return resn.next;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val + "   ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node a = new Node(1);
        a.next = new Node(2);
        a.next.next = new Node(7);
        a.next.next.next = new Node(9);

        Node b = new Node(2);
        b.next = new Node(5);
        b.next.next = new Node(7);
        b.next.next.next = new Node(11);

        printList(a);
        printList(b);

        printList(mergeTwoSortedList(a, b));

    }

}
