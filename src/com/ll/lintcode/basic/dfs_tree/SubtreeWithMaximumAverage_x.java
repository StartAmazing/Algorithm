package com.ll.lintcode.basic.dfs_tree;

import com.ll.utils.TreeNode;

//given a binary tree, find the subtree with maximum average, return the root of the subtree
public class SubtreeWithMaximumAverage_x {
    public class ResultType{
        public int size;
        public int sum;

        public ResultType(int size, int sum){
            this.size = size;
            this.sum = sum;
        }
    }

    public TreeNode resNode = null;
    public ResultType resultType = null;

    public TreeNode getSubtreeWithMaximumAverage(TreeNode root){
        ResultType res = helper(root);
        return resNode;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        ResultType rootType = new ResultType(left.size + right.size + 1
                , left.sum + right.sum + root.val);

        //直接使用出发公式的话可能会出现精度丢失或者是分母为零的异常
        if(resNode == null || resultType.size * rootType.sum > resultType.sum * rootType.size){
            resultType = rootType;
            resNode = root;
        }

        return resultType;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);

        SubtreeWithMaximumAverage_x dto = new SubtreeWithMaximumAverage_x();
        TreeNode resRoot = dto.getSubtreeWithMaximumAverage(root);
        System.out.println(resRoot.val);
    }


}
