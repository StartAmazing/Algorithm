package com.ll.leetcode;

import com.ll.utils.ListNode;

/**
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *  
 *
 * 插入排序算法：
 *
 * 插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *  
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insertion-sort-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertionSortList_147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode dummyCur = new ListNode(-1);
        dummyCur.next = curNode;
        ListNode startNode, dummyHead = new ListNode(-1), dummyStart;
        dummyHead.next = head;

        while (curNode != null) {
            startNode = dummyHead.next;
            dummyStart = dummyHead;
            while (startNode.val < curNode.val) {
                dummyStart = startNode;
                startNode = startNode.next;
            }

            if (startNode == curNode) {
                dummyCur = curNode;
                curNode = curNode.next;
            } else {
                insert(startNode, dummyStart, curNode, dummyCur);
                curNode = dummyCur.next;
            }
        }

        return dummyHead.next;
    }

    private void insert(ListNode node1, ListNode dummy1, ListNode node2, ListNode dummy2) {
        dummy2.next  = node2.next;
        dummy1.next = node2;
        node2.next = node1;
    }

    public static void main(String[] args) {
        InsertionSortList_147 dto = new InsertionSortList_147();
        ListNode data = new ListNode(4);
        data.next = new ListNode(2);
        data.next.next = new ListNode(1);
        data.next.next.next = new ListNode(3);
        ListNode.printList(data);
        System.out.println();
        ListNode.printList(dto.insertionSortList(data));
    }
}
