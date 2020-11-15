package com.ll.lintcode.basic.array.link;

import com.ll.utils.ListNode;

/**
 * K组翻转链表
 * 给你一个链表一个k值，将这个链表从头指针开始每k个翻转一下，
 * 链表元素个数不是k的倍数，最后剩余的不用翻转
 * input: 1 -> 2 —> 3 -> 4 -> 5 -> null   k = 3
 * output: 3 -> 2 -> 1 -> 4 -> 5 -> null
 */
public class ReverseNodesInKGroup_450 {

    public ListNode reverseKGroup(ListNode head, int k) {

        //1 -> 2 -> 3 -> 4 -> 5
        // ==>  3 -> 2 -> 1 -> 4 -> 5
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        while (prev != null) {
            prev = reverseNextKNodes(prev, k);
        }

        return dummy.next;
    }

    //head -> n1 -> n2 -> .... -> nk -> nk+1
    // =>
    //head -> nk -> nk-1 -> .... -> n1 -> nk+1
    private ListNode reverseNextKNodes(ListNode head, int k) {

        //find kth node
        ListNode cur = head;
        //connect kplus and as return value
        ListNode n1 = head.next;
        for (int i = 0; i < k; i++){
            cur = cur.next;
            if (cur == null){
                return null;
            }
        }

        //head to connect
        ListNode nk = cur;
        ListNode nkplus = cur.next;

        //reverse those node
        ListNode prev = head;
        cur = head.next;
        while (cur != nkplus){
            ListNode tmpNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tmpNode;
        }
        //head connect to nk
        head.next = nk;

        //n1 connect to nkplus
        n1.next = nkplus;

        //return n1(as the pre of nplus for the next loop in main method)
        return n1;
    }
}
