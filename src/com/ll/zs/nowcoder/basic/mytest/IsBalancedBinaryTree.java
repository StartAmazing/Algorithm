package com.ll.zs.nowcoder.basic.mytest;

import com.ll.zs.nowcoder.tree.Tree;

public class IsBalancedBinaryTree {

    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val){
            this.val = val;
        }
    }

    private class ResultType{
        boolean isBalanced;
        int maxHeight;

        public ResultType(boolean isBalanced, int maxHeight){
            this.isBalanced = isBalanced;
            this.maxHeight = maxHeight;
        }
    }

    public boolean isBalanced(TreeNode root){
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true,0);
        }

        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);

        if(!leftRes.isBalanced || !rightRes.isBalanced || Math.abs(leftRes.maxHeight - rightRes.maxHeight) > 1) {
            return new ResultType(false, Math.max(leftRes.maxHeight, rightRes.maxHeight));
        }

        return new ResultType(true, Math.max(leftRes.maxHeight, rightRes.maxHeight) + 1);

    }



    public boolean isBalanced2(TreeNode root){
        return helper2(root) != -1;
    }

    private int helper2(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftRes = helper2(root.left);
        int rightRes = helper2(root.right);

        if(leftRes == -1 || rightRes == -1 || Math.abs(leftRes - rightRes) > 1){
            return -1;
        }

        return Math.max(leftRes, rightRes) + 1;
    }
}

