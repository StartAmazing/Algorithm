package com.ll.lintcode.dfs_tree;

import com.ll.lintcode.utils.TreeNode;

public class MinimumSubtree_x {

    private TreeNode subTree = null;
    private Integer minSum = Integer.MAX_VALUE;

    public TreeNode getMinimalSubtree(TreeNode root){
        helper(root);
        return subTree;
    }

    //1. returns roots.sum
    private int helper(TreeNode node){

        if(node == null){
            return 0;
        }

        //divide conquer/merge
        //分治
        int leftVal = helper(node.left);
        int rightVal = helper(node.right);

        int sum = leftVal + rightVal + node.val;

        //traverse (compare with global variable)
        //打擂台
        if(sum < minSum){
            minSum = sum;
            subTree = node;
        }

        return sum;
    }

}
