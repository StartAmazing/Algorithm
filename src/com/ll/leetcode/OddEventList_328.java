package com.ll.leetcode;

import com.ll.utils.ListNode;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 *
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 *
 * 示例 1:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 *
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 *
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/odd-even-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class OddEventList_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddDummy = new ListNode(-1);
        ListNode evenDummy = new ListNode(-2);
        boolean flag = true;
        ListNode curNode = head, curOddNode = oddDummy, curEvenNode = evenDummy;
        while (curNode != null) {
            if (flag) {
                curEvenNode.next = curNode;
                curNode = curNode.next;
                curEvenNode = curEvenNode.next;
                curEvenNode.next = null;
            } else {
                curOddNode.next = curNode;
                curNode = curNode.next;
                curOddNode = curOddNode.next;
                curOddNode.next = null;
            }
            flag = !flag;
        }

        curEvenNode.next = oddDummy.next;
        return evenDummy.next;
//        if (evenSize > oddSize) {   // 偶节点长时，以偶节点开始
////            return merge(evenDummy.next, oddDummy.next);
//            curEvenNode.next = oddDummy.next;
//            return evenDummy.next;
//        } else {       // 奇节点多时，以奇节点开始
////            return merge(oddDummy.next, evenDummy.next);
//            curOddNode.next = evenDummy.next;
//            return oddDummy.next;
//        }
    }

    private ListNode merge(ListNode first, ListNode second) {
        ListNode cur1 = first, cur2 = second, next1 = first.next,next2 = second.next;
        while (next1 != null) {
            cur1.next = cur2;
            cur2 = next1;
            next1 = next2;
            next2 = cur2.next;
            cur1 = cur1.next;
        }
        return first;
    }

    public static void main(String[] args) {
        OddEventList_328 dto = new OddEventList_328();

        // 输入: 2->1->3->5->6->4->7->NULL
        ListNode data = new ListNode(2);
        data.next = new ListNode(1);
        data.next.next = new ListNode(3);
        data.next.next.next = new ListNode(5);
        data.next.next.next.next = new ListNode(6);
        data.next.next.next.next.next = new ListNode(4);
        data.next.next.next.next.next.next = new ListNode(7);

        ListNode listNode = dto.oddEvenList(data);
        ListNode.printList(listNode);
    }
}
