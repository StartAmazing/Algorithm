package com.ll.lintcode.basic.dfs;

import com.ll.lintcode.basic.utils.TreeNode;

/**
 * 给一棵二叉树，找到有最大平均值的子树。返回子树的根结点。
 *
 * 样例
 * 样例1
 *
 * 输入：
 * {1,-5,11,1,2,4,-2}
 * 输出：11
 * 说明:
 * 这棵树如下所示：
 *      1
 *    /   \
 *  -5     11
 *  / \   /  \
 * 1   2 4    -2
 * 11子树的平均值是4.333，为最大的。
 * 样例2
 *
 * 输入：
 * {1,-5,11}
 * 输出：11
 * 说明:
 *      1
 *    /   \
 *  -5     11
 * 1,-5,11 三棵子树的平均值分别是 2.333,-5,11。因此11才是最大的
 * 注意事项
 * LintCode会打印出根结点为你返回节点的子树，保证有最大平均数子树只有一棵
 */
public class FindSubtreeII_597 {

    class ResultType{
        public int sum;
        public int number;

        public ResultType(int sum, int number){
            this.sum = sum;
            this.number = number;
        }
    }

    private ResultType subStree = null;
    private TreeNode subRes = null;

    public TreeNode findSubtree(TreeNode root){
        if (root == null){
            return root;
        }
        return subRes;
    }

    private ResultType helper(TreeNode root){
        if (root == null){
            return new ResultType(0, 0);
        }

        ResultType left = helper(root.left);
        ResultType right = helper(root.right);

        int sum = left.sum + right.sum + root.val;
        int number = left.number + right.number + 1;

        ResultType curRes = new ResultType(sum, number);

        if (subStree == null || sum * subStree.number > subStree.sum * number ){
            subStree = curRes;
            subRes = root;
        }

        return curRes;
    }
}
