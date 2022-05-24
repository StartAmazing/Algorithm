package com.ll.nine_chapter.base.c_breadth_first_search;

import com.ll.utils.ListNode;
import com.ll.utils.TreeNode;
import com.sun.org.apache.bcel.internal.generic.FSUB;

import java.util.*;

/**
 * 二叉树的层次遍历
 */
public class BinaryTree {

    public static List<Integer> levelTraverseBinaryTree(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            res.add(curNode.val);
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }

        return res;
    }


    public static String serializeBinaryTree(TreeNode head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return sb.append("#").toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.poll();
            if (curNode == null) {
                sb.append("#");
            } else {
                sb.append(curNode.val);
                if (curNode.left == null) {
                    queue.add(null);
                } else {
                    queue.add(curNode.left);
                }
                if (curNode.right == null) {
                    queue.add(null);
                } else {
                    queue.add(curNode.right);
                }
            }

            if (!queue.isEmpty()) {
                sb.append("->");
            }
        }

        return sb.toString();
    }

    /**
     * @link https://www.lintcode.com/problem/70/
     * @param root
     */
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Stack<List<Integer>> stack = new Stack<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subArr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                subArr.add(curNode.val);
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }

                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            stack.push(subArr);
        }

        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }

        return res;
    }

    /**
     * @link https://www.lintcode.com/problem/71/
     * @param root
     * @return
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subRes = new ArrayList<>();
            for (int i = size; i > 0; i--) {
                TreeNode curNode = queue.poll();
                subRes.add(curNode.val);
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
            }
            if (!flag) {
                Collections.reverse(subRes);
            }
            flag = !flag;
            res.add(subRes);
        }

        return res;
    }

    /**
     * @link https://www.lintcode.com/problem/242/
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public static List<ListNode> binaryTreeToLists(TreeNode root) {
        List<ListNode> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ListNode subHead = new ListNode(-1);
            ListNode next = subHead;
            for (int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                next.next = new ListNode(curNode.val);
                next = next.next;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }

            res.add(subHead.next);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        System.out.println();
        System.out.println(levelTraverseBinaryTree(head));
        System.out.println(serializeBinaryTree(head));
        System.out.println(levelOrderBottom(head));
        System.out.println(zigzagLevelOrder(head));
        List<ListNode> listNodes = binaryTreeToLists(head);
        System.out.println("[");
        for (int i = 0; i < listNodes.size(); i++) {
            System.out.print("    ");
            ListNode.printList(listNodes.get(i));
            System.out.println();
        }
        System.out.println("]");
    }
}
