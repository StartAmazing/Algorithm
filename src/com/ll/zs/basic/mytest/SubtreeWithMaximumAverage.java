package com.ll.zs.basic.mytest;

/**
 * Given a binary tree, find the subtree with maximum average, Return the root of the subtree
 */
public class SubtreeWithMaximumAverage {


    private static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        private TreeNode(int val){
            this.val = val;
        }
    }

    private static class ResultType{
        int sum;
        int size;
        private ResultType(int sum, int size){
            this.sum = sum;
            this.size = size;
        }
    }

    static TreeNode maxAveSubtree = null;
    static ResultType subtreeResult = null;

    /**
     * divide conquer
     * @param root
     * @return
     */
    public static TreeNode getMaximumAverage(TreeNode root){
        helper(root);
        return maxAveSubtree;
    }

    private static ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(0,0);
        }

        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);

        int sum = leftRes.sum + rightRes.sum + root.val;
        int size = leftRes.size + rightRes.size + 1;
        ResultType rootResult =  new ResultType(sum,size);

        if(maxAveSubtree == null || subtreeResult.sum * rootResult.size >= subtreeResult.size * rootResult.sum){
            maxAveSubtree = root;
            subtreeResult = rootResult;
        }

        return rootResult;
    }

    /**
     * divide conquer
      * @param root
     */
    private boolean isValidBST(TreeNode root){
        return divComq(root,Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean divComq(TreeNode root, Long min, Long max){
        if(root == null){
            return  true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }

        return divComq(root.left, min, Math.min(max,root.val)) &&
                divComq(root.right, Math.max(min,root.val),max);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-5);
        root.right = new TreeNode(11);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(-2);

        TreeNode maximumAverage = getMaximumAverage(root.right);
        System.out.println(maximumAverage.val);
    }

}
