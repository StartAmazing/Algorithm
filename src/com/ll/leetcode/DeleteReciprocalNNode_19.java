package com.ll.leetcode;

public class DeleteReciprocalNNode_19 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            this.val = x;
            this.next = null;
        }
        public int getLength(){
            int len = 1;
            while(this.next != null){
                len ++;
                this.next = this.next.next;
            }
            return len;
        }

    }

    //1、使用一个指针，遍历两次算法
    public static ListNode solution(ListNode head, int n){
        if(n < 0 || n > head.getLength()){
            throw new RuntimeException("your step is illegal!");
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head;
        int length = 0;
        while(first != null){
            length ++;
            first = first.next;
        }

        length -= n;
        first = dummy;
        while(length > 0){
            length --;
            first = first.next;
        }
        first.next = first.next.next;
        return dummy.next;
    }

    //2、使用两个指针，遍历一次算法
    public static ListNode solution2(ListNode head, int n){
        if(n < 0 || n > head.getLength()){
            throw new RuntimeException("your step is illegal!");
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode preNode = head;
        ListNode afterNode = head;
        int step = n + 1;
        while(step != 0){
            preNode = preNode.next;
            step --;
        }

        while(preNode != null){
            preNode = preNode.next;
            afterNode = afterNode.next;
        }

        afterNode.next = afterNode.next.next;
        return dummy.next;
    }


    private static void printNode(ListNode head){
        while(head != null){
            System.out.print(head.val);
            if(head.next != null){
                System.out.print(" -> ");
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        printNode(listNode);
        System.out.println();

        solution(listNode,2);
        printNode(listNode);
        System.out.println();

        solution2(listNode, 1);
        printNode(listNode);
        System.out.println();
        System.out.println(listNode.getLength());


    }



}
