package com.ll.lintcode.basic.dfs;

import com.ll.utils.TreeNode;

/**
 * 给定一个二叉树,确定它是高度平衡的。对于这个问题,一棵高度平衡的二叉树的定义是：一棵二叉树中每个节点的两个子树的深度相差不会超过1。
 *
 * 样例
 * 样例  1:
 * 	输入: tree = {1,2,3}
 * 	输出: true
 *
 * 	样例解释:
 * 	如下，是一个平衡的二叉树。
 * 		  1
 * 		 / \
 * 		2  3
 *
 *
 * 样例  2:
 * 	输入: tree = {3,9,20,#,#,15,7}
 * 	输出: true
 *
 * 	样例解释:
 * 	如下，是一个平衡的二叉树。
 * 		  3
 * 		 / \
 * 		9  20
 * 		  /  \
 * 		 15   7
 *
 *
 * 样例  2:
 * 	输入: tree = {1,#,2,3,4}
 * 	输出: false
 *
 * 	样例解释:
 * 	如下，是一个不平衡的二叉树。1的左右子树高度差2
 * 		  1
 * 		   \
 * 		   2
 * 		  /  \
 * 		 3   4
 */


public class IsBalanced_93 {
    class ResultType{
        public int maxDepth;
        public boolean isBalance;

        public ResultType(boolean isBalance, int maxDepth){
            this.isBalance = isBalance;
            this.maxDepth = maxDepth;
        }
    }

    //version1: Divided Conquer
    public boolean isBalancedx(TreeNode root){
        if (root == null){
            return true;
        }
        return getIsBalanced(root).isBalance;
    }

    private ResultType getIsBalanced(TreeNode root){
        if (root == null){
            return new ResultType(true, 0);
        }

        ResultType left = getIsBalanced(root.left);
        ResultType right = getIsBalanced(root.right);

        if (!left.isBalance || !right.isBalance || Math.abs(left.maxDepth - right.maxDepth) > 1){
            return new ResultType(false, -1);
        }

       return new ResultType(left.isBalance && right.isBalance && Math.abs(left.maxDepth - right.maxDepth) <= 1 , Math.max(left.maxDepth,right.maxDepth) + 1);

    }

    private int IS_NOT_BALANCED = -1;

    //version2: Traversal
    public boolean isBalanced(TreeNode root){
        if (root == null){
            return true;
        }
        return helper(root) == IS_NOT_BALANCED;
    }

    private int helper(TreeNode root){
        if (root == null){
            return 0;
        }

        int left = helper(root.left);
        int right = helper(root.right);

        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left,right);
    }

}
