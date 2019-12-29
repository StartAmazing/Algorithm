package com.ll.zs.basic.mytest;

public class MinimumSubtree {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int val){
            this.val = val;
        }
    }

    private static Integer minimumNum = Integer.MAX_VALUE;
    private static TreeNode subTree = null;

    private static TreeNode getMinimumSubtree(TreeNode root){
        helper(root);
        return subTree;
    }

    private static int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int min = helper(root.left) + helper(root.right) + root.val;

        if(min < minimumNum){
            subTree = root;
            minimumNum = min;
        }
        return min;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(-4);
        root.right.right = new TreeNode(-5);
        TreeNode minimumSubtree = getMinimumSubtree(root);
        System.out.println(minimumSubtree.val);
    }

}
