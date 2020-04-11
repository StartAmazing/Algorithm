package com.ll.lintcode.basic.array.link;

import com.ll.leetcode.ListNode;

/**
 * 翻转链表中第m个节点到第n个节点的部分
 *
 * 样例
 * 例1:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 输出: 1->4->3->2->5->NULL.
 * 例2:
 *
 * 输入: 1->2->3->4->NULL, m = 2 and n = 3,
 * 输出: 1->3->2->4->NULL.
 * 挑战
 * Reverse it in-place and in one-pass
 *
 * 注意事项
 * m，n满足1 ≤ m ≤ n ≤ 链表长度
 */
public class ReverseLinkedListII_36 {

    public ListNode reverseBetween(ListNode head, int m, int n){
        if(m > 1) {
            ListNode before = new ListNode(-1);
            before.next = head;

            while (before != null && m > 1) {
                m--;
                before = before.next;
            }
            if(before == null){
                return null;
            }
            ListNode start = before.next;
            before.next = getReversedHead(start, n - m + 1);
            return head;
        }else{
            return getReversedHead(head, n - m + 1);
        }
    }

    private ListNode getReversedHead(ListNode head, int m){
        ListNode cur = head;
        while (m > 1){
            m --;
            cur = cur.next;
        }
        ListNode resNext = cur.next;
        cur.next = null;

        ListNode pre = new ListNode(-1);
        pre.next = head;
        cur = head;
        ListNode curNext;
        while (cur != null){
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        head.next = resNext;

        return pre;
    }



    //version 2
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode start = head;
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode pre = null;
        int x = m;
        while(x > 1 && start != null){
            x--;
            first = first.next;
            start = start.next;
        }

        ListNode cur = start;
        ListNode curNext = start;
        while(cur != null && n > m - 1){
            n --;
            curNext = cur.next;
            cur.next = pre;
            pre = cur;
            cur = curNext;
        }
        if(cur != null){
            first.next.next = cur;
        }
        first.next = pre;

        if(m == 1){
            return pre;
        }else{
            return head;
        }
    }
}
