package com.ll.zs.nowcoder.basic.mytest;

import java.util.LinkedList;

public class ConvertBST2DoublyLinkedList {
    /**
     * Definition for Doubly-ListNode.
     */
    public static class DoublyListNode {
        int val;
        DoublyListNode next, prev;

        DoublyListNode(int val) {
            this.val = val;
            this.next = this.prev = null;
        }
    }

    public static class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    /**
     * @param root: The root of tree
     * @return: the head of doubly list node
     */
    public static DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        DoublyListNode head = new DoublyListNode(-1);
        DoublyListNode xx = head;
        LinkedList<DoublyListNode> queue = new LinkedList<>();
        helper(root, queue);
        while (queue.size() > 0){
            DoublyListNode cur = queue.poll();
            xx.next = cur;
            cur.prev = xx;
            xx = xx.next;
        }
        return head.next;
    }

    private static void helper(TreeNode root, LinkedList queue) {
        if (root == null) {
            return;
        }
        helper(root.left,queue);
        queue.add(new DoublyListNode(root.val));
        helper(root.right,queue);
    }

    private static void printList(DoublyListNode root){
        while (root != null){
            System.out.print(root.val + "< - >");
            root = root.next;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(5);

        DoublyListNode doublyListNode = bstToDoublyList(root);
        printList(doublyListNode);
    }
}
