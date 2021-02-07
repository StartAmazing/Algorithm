package com.ll.lintcode.advance.chapter1.twopoint.syntropy.window;

import com.ll.utils.ListNode;

/**
 * 给定一个链表，删除链表中倒数第n个节点，返回链表的头节点。
 *
 *
 *
 * 样例
 * Example 1:
 * 	Input: list = 1->2->3->4->5->null， n = 2
 * 	Output: 1->2->3->5->null
 *
 *
 * Example 2:
 * 	Input:  list = 5->4->3->2->1->null, n = 2
 * 	Output: 5->4->3->1->null
 *
 * 挑战
 * O(n)时间复杂度
 *
 * 注意事项
 * 链表中的节点个数大于等于n
 */
public class RemoveNthFromEnd_174 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int count = n;
        ListNode left = head, right = head, dummyNode = new ListNode(-1);
        dummyNode.next = head;
        while (count > 0) {
            count--;
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
            dummyNode = dummyNode.next;
        }

        if (dummyNode.next == head) {
            dummyNode.next = left.next;
            return dummyNode.next;
        }
        dummyNode.next = left.next;
        return head;
    }

    public static void main(String[] args) {
        RemoveNthFromEnd_174 dto = new RemoveNthFromEnd_174();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = dto.removeNthFromEnd(head, 5);

        ListNode.printList(listNode);
    }
}
