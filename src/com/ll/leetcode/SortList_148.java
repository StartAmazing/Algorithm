package com.ll.leetcode;

import com.ll.utils.ListNode;

/**
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  
 *
 * 示例 1：
 *
 *
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 示例 2：
 *
 *
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 104] 内
 * -105 <= Node.val <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortList_148 {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getPreMidNode(head);
        ListNode midNext = mid.next;
        mid.next = null;
        ListNode part1 = sortList(head);
        ListNode part2 = sortList(midNext);
        return mergeTwoSortedList(part1, part2);
    }


    private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode idx1 = list1, idx2 = list2, dummy = new ListNode(-1);
        ListNode res = dummy;
        while (idx1 != null && idx2 != null) {
            if (idx1.val < idx2.val) {
                dummy.next = idx1;
                idx1 = idx1.next;
            } else {
                dummy.next = idx2;
                idx2 = idx2.next;
            }

            dummy = dummy.next;
        }

        if (idx1 != null) {
            dummy.next = idx1;
        }
        if (idx2 != null) {
            dummy.next = idx2;
        }

        return res.next;
    }

    private ListNode getPreMidNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
