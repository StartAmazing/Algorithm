package com.ll.lintcode.basic.dfs_tree;


import com.ll.utils.TreeNode;

public class MaxBinaryTreeDepth_97 {

    //1. divide conquer
    private int maxDepth = Integer.MIN_VALUE;

    public int getMaxBinaryTreeDepthDivide(TreeNode root){
        if(root == null){
            return 0;
        }
        maxDepth = 1;
        helper(root,1);
        return maxDepth;
    }

    private void helper(TreeNode node, int curDepth){
        if(node == null){
            return;
        }
        if(curDepth > maxDepth){
            maxDepth = curDepth;
        }
        helper(node.left,curDepth + 1);
        helper(node.right,curDepth + 1);
    }


    //2. traverse
    public int getMaxBinaryTreeDepthRec(TreeNode root){

        if(root == null){
            return 0;
        }
        int leftDepth = getMaxBinaryTreeDepthRec(root.left);
        int rightDepth = getMaxBinaryTreeDepthRec(root.right);
        return Math.max(leftDepth, rightDepth)  + 1;
    }


}
