package com.ll.lintCode.dfs;

import com.ll.lintCode.utils.TreeNode;

public class BalancedBinaryTree_93 {
    //1. with ResultType
    public class ResultType{
        public int height;
        public boolean isBalanced;
        public ResultType(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public boolean isBalancedTreeResType(TreeNode root){
        return helper(root).isBalanced;
    }

    private ResultType helper(TreeNode root){

        if(root == null){
            return new ResultType(0,true);
        }

        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);

        //subTree not balanced
        if(!leftRes.isBalanced || !rightRes.isBalanced){
            return new ResultType(-1, false);
        }

        boolean resBalanced = Math.abs(leftRes.height - rightRes.height) <= 1;

        //root not balanced, not recommend
        if(!resBalanced){
            return new ResultType(-1,false);
        }

        int resHeight = Math.max(leftRes.height,rightRes.height) + 1;

        return new ResultType(resHeight,resBalanced);
    }

    //2. without ResultType
    private int IS_NOT_BALANCED = -1;

    public boolean isBalancedTreeRec(TreeNode root){
        return maxDepth(root) != IS_NOT_BALANCED;
    }

    private int maxDepth(TreeNode root){

        if(root == null){
            return 0;
        }

        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        if(leftDepth == IS_NOT_BALANCED || rightDepth == IS_NOT_BALANCED || Math.abs(leftDepth - rightDepth) > 1){
            return IS_NOT_BALANCED;
        }

        return Math.abs(rightDepth - leftDepth) > 1 ? -1 : Math.max(leftDepth,rightDepth) + 1;
    }
}
