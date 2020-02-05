package com.ll.lintcode.array.link;

import com.ll.lintcode.utils.ListNode;

/**
 * 将链表翻转
 * 1 -> 2 -> 3 -> null
 * 3 -> 2 -> 1 -> null
 */
public class ReverseLinkedList_35 {

    public ListNode reverse(ListNode head){
        ListNode preNode = null;
        ListNode curNode = head;
        while (head != null){
            head = head.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = head;
        }
        return preNode;
    }


}
