package com.ll.lintCode.array.link;

import com.ll.leetcode.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定一个链表，判断它是否有环
 */
public class LinkedListCycle_102 {

    //version 1: use a set
    public boolean hasCycle1(ListNode head){
        Set<ListNode> set = new HashSet<>();
        while (head != null){
            if (set.contains(head)){
                return true;
            }
            set.add(head);
            head = head.next;
        }
        return false;
    }

    //version 2: two pointer
    public boolean hasCycle2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


}
