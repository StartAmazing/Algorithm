package com.ll.lintcode.basic.array.link;

import com.ll.utils.ListNode;

/**
 * 给链表排序
 */
public class SortList_98 {
    //version 1： merge sort
    private ListNode sortList(ListNode head){
        if (head == null || head.next == null){
            return head;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);

        return merge(left,right);
    }

    private ListNode findMiddle(ListNode head){
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(head1 != null && head2 != null){
            if (head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null){
            tail.next = head1;
        }
        if (head2 != null){
            tail.next = head2;
        }

        return dummy.next;
    }





}
