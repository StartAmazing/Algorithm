package com.ll.lintcode.basic.array.link;

import com.ll.leetcode.ListNode;

/**
 * 给定一个链表，如果链表中存在环，则返回到链表中环的起始节点，如果没有环，返回null
 */
public class LinkedListCycleII_103 {

    public ListNode detectCycle(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                slow = head;
                while (fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        return null;
    }
}
