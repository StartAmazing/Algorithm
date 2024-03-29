package com.ll.nine_chapter.base.e_list_array;

import com.ll.utils.LinkedNode;
import com.ll.utils.ListNode;
import com.ll.utils.RandomListNode;
import com.ll.utils.TreeNode;
import com.ll.zs.msb.dp.recursion.StackReverse;

import javax.smartcardio.TerminalFactory;
import java.util.*;

public class ListAlgorithm {

    /**
     * @link https://www.lintcode.com/problem/450/
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public static ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null || head.next == null || k <= 1) {
            return head;
        }

        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curPre = dummyNode;
        while (curPre != null) {
            curPre = reverseK(curPre, k);
        }

        return dummyNode.next;
    }

    // preNode -> n1 -> n2 -> ... -> nk -> nk+1
    // =>
    // preNode -> nk -> ... -> n2 -> n1 -> nk + 1
    private static ListNode reverseK(ListNode head,
                                    int k) {
        // find kth node
        ListNode cur = head;
        ListNode n1 = head.next;
        for (int i = 0; i < k; i++) {
            cur = cur.next;
            if (cur == null) {
                return null;
            }
        }
        ListNode nK = cur;
        ListNode nKplus = cur.next;

        // reverse
        ListNode pre = head;
        cur = head.next;
        while (cur != nKplus) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }

        // head -> n1
        head.next = nK;
        n1.next = nKplus;
        return n1;
    }

    /**
     * @link https://www.lintcode.com/problem/96/
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;
        ListNode gtDummyNode = new ListNode(-1);
        ListNode gtCurNode = gtDummyNode;
        while (curNode != null) {
            if (curNode.val >= x) {
                gtCurNode.next = curNode;
                gtCurNode = gtCurNode.next;
                preNode.next = curNode.next;
                curNode = curNode.next;
                gtCurNode.next = null;
            } else {
                preNode = curNode;
                curNode = curNode.next;
            }
        }

        preNode.next = gtDummyNode.next;

        return dummyNode.next;
    }

    /**
     * @link https://www.lintcode.com/problem/165/
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummyNode = new ListNode(-1);
        ListNode curNode = dummyNode;
        ListNode h1 = l1;
        ListNode h2 = l2;
        while (h1 != null && h2 != null) {
            if (h1.val > h2.val) {
                curNode.next = h2;
                curNode = curNode.next;
                h2 = h2.next;
            } else {
                curNode.next = h1;
                curNode = curNode.next;
                h1 = h1.next;
            }
        }

        if (h1 != null) {
            curNode.next = h1;
        }

        if (h2 != null) {
            curNode.next = h2;
        }

        return dummyNode.next;
    }

    /**
     * @link https://www.lintcode.com/problem/36/
     * @param head: ListNode head is the head of the linked list
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode preNode = dummyNode;
        ListNode nNodePlus = null, mPreNode = null, startNode = null;
        int count = 1;
        while (count < m) {
            curNode =curNode.next;
            preNode = preNode.next;
            count++;
        }
        mPreNode = preNode;
        startNode = curNode;
        while (count <= n) {
            curNode =curNode.next;
            preNode = preNode.next;
            count++;
        }
        preNode.next = null;
        nNodePlus = curNode;

        mPreNode.next = reverseList(startNode, nNodePlus);

        return dummyNode.next;
    }

    private static ListNode reverseList(ListNode head, ListNode tail) {
        ListNode curNode = head.next;
        ListNode preNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }

        head.next = tail;

        return preNode;
    }

    /**
     * @link https://www.lintcode.com/problem/511/
     * @param head: a ListNode
     * @param v1: An integer
     * @param v2: An integer
     * @return: a new head of singly-linked list
     */
    public static ListNode swapNodes(ListNode head, int v1, int v2) {
        ListNode v1Pre = null, v1Next = null, v2Pre = null, v2Next = null, v1Node = null, v2Node = null;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode curNode = head;
        ListNode preNode = dummyNode;
        while (curNode != null) {
            if (curNode.val == v1) {
                v1Node = curNode;
                v1Pre = preNode;
                v1Next = curNode.next;
            }
            if (curNode.val == v2) {
                v2Node = curNode;
                v2Pre = preNode;
                v2Next = curNode.next;
            }
            curNode = curNode.next;
            preNode = preNode.next;
        }

        if (v1Node != null && v2Node != null) {
            if (v1Node.next == v2Node) {
                v2Node.next = v1Node;
                v1Node.next = v2Next;
                v1Pre.next = v2Node;
            } else if (v2Node.next == v1Node) {
                v1Node.next = v2Node;
                v2Node.next = v1Next;
                v2Pre.next = v1Node;
            } else {
                v1Pre.next = v2Node;
                v2Node.next = v1Next;
                v2Pre.next = v1Node;
                v1Node.next = v2Next;
            }
        }

        return dummyNode.next;
    }

    /**
     * @link https://www.lintcode.com/problem/99/
     * @param head: The head of linked list.
     * @return: nothing
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null  || head.next.next == null) {
            return;
        }
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
        }
        ListNode startNode = slowNode.next;
        slowNode.next = null;

        ListNode otherNode = reverseList(startNode);
        merge(head, otherNode);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode curNode = head;
        while (curNode != null) {
            ListNode next = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = next;
        }

        head.next = null;
        return preNode;
    }

    private static void merge(ListNode mainList, ListNode otherList) {
        ListNode curMain = mainList;
        ListNode curOther = otherList;
        while (curMain != null && curOther != null) {
            ListNode mainNext = curMain.next;
            ListNode otherNext = curOther.next;
            curMain.next = curOther;
            curOther.next = mainNext;
            curMain = mainNext;
            curOther = otherNext;
        }
    }

    /**
     * @link https://www.lintcode.com/problem/170/
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode leftNode = head, rightNode = head;
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        int count = 0;
        while (rightNode != null) {
            rightNode = rightNode.next;
            preNode = preNode.next;
            count++;
        }
        if (k % count == 0) {
            return head;
        }
        k = k % count;
        int n = count - k;
        ListNode tailNode = preNode;
        preNode = dummyNode;
        while (n > 0) {
            preNode = preNode.next;
            leftNode = leftNode.next;
            n--;
        }

        preNode.next = null;
        tailNode.next = head;

        return leftNode;
    }

    /**
     * @link https://www.lintcode.com/problem/105/
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    public static RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        Map<RandomListNode, RandomListNode> randomMap = new HashMap<>();
        RandomListNode cur = head;
        while (cur != null) {
            randomMap.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            RandomListNode curClone = randomMap.get(cur);
            if (cur.next != null) {
                curClone.next = randomMap.get(cur.next);
            }
            curClone.random = randomMap.get(cur.random);
            cur = cur.next;
        }

        return randomMap.get(head);
    }

    public static RandomListNode copyRandomList_noExtraSpace(RandomListNode head) {
        // write your code here
        if (head == null) {
            return head;
        }
        // 1. append random node after every node
        appendCloneNode(head);

        // 2. copy random pointer
        copyRandomPointer(head);

        // 3. split list and return cloned list
        return splitList(head);
    }

    private static void appendCloneNode(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next;
            cur.next = new RandomListNode(cur.label);
            cur.next.next = next;
            cur = next;
        }
    }

    private static void copyRandomPointer(RandomListNode head) {
        RandomListNode cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
    }

    private static RandomListNode splitList(RandomListNode head) {
        RandomListNode res = head.next;
        RandomListNode cur = head;
        while (cur != null) {
            RandomListNode next = cur.next.next;
            if (next == null) {
                cur.next.next = null;
            } else {
                cur.next.next = next.next;
            }
            cur.next = next;
            cur = cur.next;
        }
        return res;
    }

    /**
     * @link https://www.lintcode.com/problem/102/
     * @param head: The first node of linked list.
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    /**
     * @link https://leetcode.cn/problems/linked-list-cycle-ii/
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }

        return null;
    }

    /**
     * @param head: The first node of linked list
     * @return: a tree node
     */
    public static TreeNode sortedListToBST(ListNode head) {
        // write your code here
        if (head == null) {
            return null;
        }

        return toBst(head);
    }

    private static TreeNode toBst(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return new TreeNode(head.val);
        }


        ListNode mid = head, fast = head;
        ListNode midPre = new ListNode(-1);
        ListNode fastPre = midPre;
        midPre.next = head;
        while (fast != null && fast.next != null) {
            midPre = midPre.next;
            mid = mid.next;
            fast = fast.next.next;
            fastPre = fastPre.next.next;
        }

        ListNode next = mid.next;
        mid.next = null;
        midPre.next = null;

        TreeNode root = new TreeNode(mid.val);
        root.left = toBst(head);
        root.right = toBst(next);

        return root;
    }

    /**
     * @link https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/
     * @param head
     * @return
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode preNode = dummyNode;
        ListNode slow = head, fast = head;
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null
        // A              A
        // B                             B
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            preNode = preNode.next;
        }

        preNode.next = slow.next;

        return dummyNode.next;
    }

    /**
     * @link https://www.lintcode.com/problem/1534/
     * @param root: root of a tree
     * @return: head node of a doubly linked list
     */
    TreeNode pre = null, head = null;
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) return root;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(TreeNode root){
        if (root == null) return; // 递归边界: 叶子结点返回
        dfs(root.left);
        if (pre != null) {
            pre.right = root;
        }  else {
            head = root; // 链表头结点
        }
        root.left = pre;
        pre = root;
        dfs(root.right);
    }

    /**
     * @link https://www.lintcode.com/problem/98/
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode midNode = new ListNode(-1);
        midNode.next = head;
        ListNode fastNode = head;
        while(fastNode != null && fastNode.next != null) {
            midNode = midNode.next;
            fastNode = fastNode.next.next;
        }

        ListNode rightHead = midNode.next;
        midNode.next = null;

        ListNode left = sortList(head);
        ListNode right = sortList(rightHead);

        return mergex(left, right);
    }

    private static ListNode mergex(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode curHead = dummyNode;
        ListNode curLeft = left;
        ListNode curRight = right;
        while(curLeft != null && curRight != null) {
            if(curLeft.val < curRight.val) {
                curHead.next = curLeft;
                curLeft = curLeft.next;
            } else {
                curHead.next = curRight;
                curRight = curRight.next;
            }

            curHead = curHead.next;
        }

        if(curLeft != null) {
            curHead.next = curLeft;
        }

        if(curRight != null) {
            curHead.next = curRight;
        }

        return dummyNode.next;
    }

    /**
     * @link https://www.lintcode.com/problem/106/
     * @param head: The first node of linked list
     * @return: a tree node
     */
    public TreeNode sortedListToBST2(ListNode head) {
        if(head == null) {
            return null;
        }

        if(head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode fastNode = head;
        ListNode midNode = new ListNode(-1);
        midNode.next = head;
        while(fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            midNode = midNode.next;
        }

        ListNode rightHead = midNode.next.next;
        TreeNode root = new TreeNode(midNode.next.val);
        midNode.next = null;

        TreeNode leftTree = sortedListToBST(head);
        TreeNode rightTree = sortedListToBST(rightHead);

        root.left = leftTree;
        root.right = rightTree;

        return root;
    }

    /*
     * @link https://www.lintcode.com/problem/372
     * @param node: the node in the list should be deleted
     * @return: nothing
     */
    public void deleteNode(ListNode node) {
        while(node != null && node.next != null) {
            node.val = node.next.val;
            if(node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }



    public static void main(String[] args) {
//        ListNode dummyNode = new ListNode(-1);
        ListNode head = new ListNode(1);
        head.next = new ListNode(-1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
//
////        dummyNode.next = head;

//        ListNode.printList(head);
//        ListNode listNode = reverseKGroup(head, 3);
//        System.out.println();
//        ListNode.printList(listNode);
//        ListNode partition = partition(head, 3);
//        ListNode.printList(partition);
//        System.out.println();
//
//        ListNode h1 = new ListNode(0);
//        h1.next = new ListNode(3);
//        h1.next.next = new ListNode(3);
//
//        ListNode h2 = new ListNode(1);
//        h2.next = new ListNode(3);
//        h2.next.next = new ListNode(8);
//        h2.next.next.next = new ListNode(11);
//        h2.next.next.next.next = new ListNode(15);
//
//        ListNode res = mergeTwoLists(h1, h2);
//        ListNode.printList(res);
//        System.out.println();
//        ListNode res =  reverseBetween(head, 2, 4);
//        ListNode.printList(res);
//        ListNode listNode = swapNodes(head, 7, 8);
//        ListNode.printList(listNode);
//        reorderList(head);
//        ListNode.printList(head);
//        ListNode listNode = rotateRight(head, 5);
//        ListNode.printList(listNode);
//        RandomListNode randomHead = new RandomListNode(-1);
//        randomHead.next = null;
//        randomHead.random = null;
//        copyRandomList_noExtraSpace(randomHead);
        TreeNode treeNode = sortedListToBST(head);
        System.out.println(treeNode);

//        TreeNode treeNode1 = treeToDoublyList(treeNode);
//        System.out.println(treeNode1);

        ListNode listNode = sortList(head);
    }
}
