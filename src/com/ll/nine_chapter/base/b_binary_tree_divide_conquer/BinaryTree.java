package com.ll.nine_chapter.base.b_binary_tree_divide_conquer;

import com.ll.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {

    public static List<Integer> preOrder(TreeNode node) {
        List<Integer> res = new ArrayList<>();
        if (node == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }

            res.add(cur.val);
        }

        return res;
    }

    public static List<Integer> inOrder(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = head;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }

        return res;
    }

    public static List<Integer> postOrder(TreeNode head) {
        List<Integer> res = new ArrayList<>();
        if (head == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> help = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            help.push(curNode);
            if(curNode.left != null){
                stack.push(curNode.left);
            }
            if(curNode.right != null){
                stack.push(curNode.right);
            }
        }
        while(!help.isEmpty()){
            res.add(help.pop().val);
        }
        return res;
    }

    public static List<Integer> preOrderDivideConquer(TreeNode head) {
        ArrayList<Integer> res = new ArrayList<>();
        if (head == null) {
            return res;
        }

        res.add(head.val);
        List<Integer> leftRes = preOrderDivideConquer(head.left);
        List<Integer> rightRes = preOrderDivideConquer(head.right);

        res.addAll(leftRes);
        res.addAll(rightRes);

        return res;
    }

    private static int depth;

    /**
     * 二叉树最大深度
     * @param head
     * @return
     */
    public static int maxDepthOfBinaryTreeTraverse(TreeNode head) {
        depth = 0;
        if (head == null){
            return depth;
        }
        depthHelper(head, 1);
        return depth;
    }

    private static void depthHelper(TreeNode head, int currentDepth) {
        if (head == null) {
            return;
        }
        if (currentDepth > depth) {
            depth = currentDepth;
        }

        depthHelper(head.left, currentDepth + 1);
        depthHelper(head.right, currentDepth + 1);
    }

    /**
     * 二叉树最大深度
     * @param head
     * @return
     */
    public static int maxDepthOfBinaryTreeDivideConquer(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int leftDepth = maxDepthOfBinaryTreeDivideConquer(head.left);
        int rightDepth = maxDepthOfBinaryTreeDivideConquer(head.right);

        return Math.max(leftDepth + 1, rightDepth + 1);
    }

    /**
     * 二叉树从根到子节点的路径
     * @param head
     * @return
     */
    private static List<String> res = new ArrayList<>();
    public static List<String> binaryTreePathTraverse(TreeNode head) {
        if (head == null) {
            return res;
        }

        binaryTreePathHelper(head, "");
        return res;
    }

    private static void binaryTreePathHelper(TreeNode root, String subString) {
        if (root == null) {
            res.add(subString.substring(0, subString.length() - 2));
            return;
        }
        StringBuilder sb = new StringBuilder().append(subString)
                                              .append(root.val)
                                              .append("->");
        binaryTreePathHelper(root.left, sb.toString());
        binaryTreePathHelper(root.right, sb.toString());
    }

    public static List<String> binaryTreePathDivideConquer(TreeNode head) {
        List<String> res = new ArrayList<>();
        if (head == null) {
            return res;
        }

        if (head.left == null && head.right == null) {
            res.add(String.valueOf(head.val));
        }

        List<String> leftRes = binaryTreePathDivideConquer(head.left);
        List<String> rightRes = binaryTreePathDivideConquer(head.right);

        List<String> mergedRes = new ArrayList<>(leftRes);
        mergedRes.addAll(rightRes);
        for (String subStr : mergedRes) {
            res.add(head.val + "->" + subStr);
        }
        return res;
    }

    private static int minSum = Integer.MAX_VALUE;
    public static int minimumSubtree(TreeNode head) {
        if (head == null) {
            return 0;
        }
        minSumHelper(head);
        return minSum;
    }

    private static int minSumHelper(TreeNode head) {
        if (head == null) {
            return 0;
        }

        int leftSum = minSumHelper(head.left);
        int rightSum = minSumHelper(head.right);

        minSum = Math.min(leftSum + rightSum + head.val, minSum);

        return leftSum + rightSum + head.val;
    }

    //  ======================== Result Type ==============
    private static class BalancedBinaryTreeResultType {
        int height;
        boolean isBalanced;

        public BalancedBinaryTreeResultType() {

        }

        public BalancedBinaryTreeResultType(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static boolean isBalancedBinaryTree(TreeNode head) {
        if (head == null) {
            return true;
        }

        return balanceHelper(head).isBalanced;
    }

    private static BalancedBinaryTreeResultType balanceHelper(TreeNode root) {
        if (root == null) {
            return new BalancedBinaryTreeResultType(0, true);
        }

        BalancedBinaryTreeResultType leftBalance = balanceHelper(root.left);
        BalancedBinaryTreeResultType rightBalance = balanceHelper(root.right);

        boolean balanced = leftBalance.isBalanced && rightBalance.isBalanced && (Math.abs(leftBalance.height - rightBalance.height) <= 1);

        return new BalancedBinaryTreeResultType(Math.max(leftBalance.height, rightBalance.height) + 1, balanced);
    }

    private static class SubTreeWithMaximumAverageResultType {
        int size;
        int sum;

        public SubTreeWithMaximumAverageResultType(){}

        public SubTreeWithMaximumAverageResultType(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
    }

    private static TreeNode resultNode = null;
    private static SubTreeWithMaximumAverageResultType maxResultType = null;
    public static TreeNode subTreeWithMaximumAverage(TreeNode head) {
        if (head == null) {
            return head;
        }
        subTreeWithMaximumAverageHelper(head);
        return resultNode;
    }

    private static SubTreeWithMaximumAverageResultType subTreeWithMaximumAverageHelper(TreeNode root) {
        if (root == null) {
            return new SubTreeWithMaximumAverageResultType(0, 0);
        }

        SubTreeWithMaximumAverageResultType leftRes = subTreeWithMaximumAverageHelper(root.left);
        SubTreeWithMaximumAverageResultType rightRes = subTreeWithMaximumAverageHelper(root.right);

        int totalSize = leftRes.size + rightRes.size + 1;
        int sum = leftRes.sum + rightRes.sum + root.val;

        SubTreeWithMaximumAverageResultType newResult = new SubTreeWithMaximumAverageResultType(totalSize, sum);
        if (resultNode == null || newResult.sum *  maxResultType.size >= newResult.size * maxResultType.sum) {
            resultNode = root;
            maxResultType = newResult;
        }

        return newResult;
    }

    /**
     * lowest common Ancestor
     * @param root
     * @param nodeA
     * @param nodeB
     * 1. 考虑TreeNode是否可能存在父指针
     * 2. 大多情况下没有父指针
     *    如果A和B都在root下面， return lca(a, b)
     *    如果只有A在，return A
     *    如果只有B在，return B
     *    如果都不在，return null
     */
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode nodeA, TreeNode nodeB) {
        if (root == null || root == nodeA || root == nodeB) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, nodeA, nodeB);
        TreeNode right = lowestCommonAncestor(root.right, nodeA, nodeB);

        if (left != null && right != null) {
            return root;
        }

        if (left != null) {
            return left;
        }

        if (right != null) {
            return right;
        }

        return null;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(1);
        head.left = new TreeNode(2);
        head.right = new TreeNode(3);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(5);
        head.right.left = new TreeNode(6);
        head.right.right = new TreeNode(7);
        head.right.right.right= new TreeNode(7);
        head.right.right.right.right = new TreeNode(7);
        System.out.println(preOrder(head));
        System.out.println(inOrder(head));
        System.out.println(postOrder(head));
        System.out.println(preOrderDivideConquer(head));
        System.out.println(maxDepthOfBinaryTreeTraverse(head));
        System.out.println(maxDepthOfBinaryTreeDivideConquer(head));
        System.out.println(binaryTreePathTraverse(head));  // something went wrong
        System.out.println(binaryTreePathDivideConquer(head));
        System.out.println(minimumSubtree(head));
        System.out.println(isBalancedBinaryTree(head));
        System.out.println(subTreeWithMaximumAverage(head).val);
    }
}