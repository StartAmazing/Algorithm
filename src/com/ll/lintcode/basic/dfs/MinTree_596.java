package com.ll.lintcode.basic.dfs;

import com.ll.utils.TreeNode;

/**
 * 给一棵二叉树, 找到和为最小的子树, 返回其根节点。输入输出数据范围都在int内。
 * <p>
 * 样例
 * 样例 1:
 * <p>
 * 输入:
 * {1,-5,2,1,2,-4,-5}
 * 输出:1
 * 说明
 * 这棵树如下所示：
 *     1
 *   /   \
 * -5     2
 * / \   /  \
 * 1  2 -4  -5
 * 整颗树的和是最小的，所以返回根节点1.
 * 样例 2:
 * <p>
 * 输入:
 * {1}
 * 输出:1
 * 说明:
 * 这棵树如下所示：
 * 1
 * 这棵树只有整体这一个子树，所以返回1.
 * 注意事项
 * LintCode会打印根节点为你返回节点的子树。保证只有一棵和最小的子树并且给出的二叉树不是一棵空树。
 */


public class MinTree_596 {
    class ResultType {
        public int min;
        public TreeNode minNode;
        public int sum;

        public ResultType(int min, TreeNode minNode, int sum) {
            this.min = min;
            this.minNode = minNode;
            this.sum = sum;
        }
    }
    //version1: Divide Conquer
    public TreeNode findSubtree(TreeNode root) {
        if (root == null) {
            return null;
        }
        return getMinSubtree(root).minNode;
    }

    private ResultType getMinSubtree(TreeNode root) {

        if (root == null) {
            return new ResultType(Integer.MAX_VALUE, null, 0);
        }

        ResultType left = getMinSubtree(root.left);
        ResultType right = getMinSubtree(root.right);

        ResultType res = new ResultType(left.sum + right.sum + root.val, root, left.sum + right.sum + root.val);

        if (res.min >= left.min) {
            res.min = left.min;
            res.minNode = left.minNode;
        }

        if (res.min >= right.min) {
            res.min = right.min;
            res.minNode = right.minNode;
        }

        return res;
    }

    //version2: traversal
    private TreeNode minSubtree = null;
    private int minSum = Integer.MAX_VALUE;

    public TreeNode findSubtreeReversal(TreeNode root){
        helper(root);
        return minSubtree;
    }

    private int helper(TreeNode root){
        if (root == null){
            return 0;
        }
        int sum = helper(root.left) + helper(root.right) + root.val;
        if (minSum >= sum){
            minSubtree = root;
            minSum = sum;
        }

        return sum;
    }

}
