package com.ll.lintcode.dfs;

import com.ll.lintcode.utils.TreeNode;
import com.ll.zs.tree.Tree;

/**
 * 给定一棵二叉树，找到两个节点的最近公共父节点(LCA)。
 *
 * 最近公共祖先是两个节点的公共的祖先节点且具有最大深度。
 *
 * 样例
 * 样例 1:
 *
 * 输入：{1},1,1
 * 输出：1
 * 解释：
 *  二叉树如下（只有一个节点）:
 *          1
 *  LCA(1,1) = 1
 * 样例 2:
 *
 * 输入：{4,3,7,#,#,5,6},3,5
 * 输出：4
 * 解释：
 *  二叉树如下:
 *
 *       4
 *      / \
 *     3   7
 *        / \
 *       5   6
 *
 *  LCA(3, 5) = 4
 * 注意事项
 * 假设给出的两个节点都在树中存在
 */
public class LowestCommonAncestor_88 {

    class ResultType{
        public boolean visitedA, visitedB;
        public TreeNode curNode;

        public ResultType(boolean visitedA, boolean visitedB, TreeNode curNode){
            this.visitedA = visitedA;
            this.visitedB = visitedB;
            this.curNode = curNode;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        if (root == null || root == A || root == B){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);

        if (left != null && right != null){
            return root;
        }
        if (left != null){
            return left;
        }
        if (right != null){
            return right;
        }
        return null;
    }

    //version2: divide conquer
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return root;
        }
        ResultType res = helper(root, A, B);
        if (res.visitedA && res.visitedB){
            return res.curNode;
        }else{
            return null;
        }
    }

    private ResultType helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new ResultType(false,false, root);
        }
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);

        boolean a_exist = root == A || left.visitedA || right.visitedA;
        boolean b_exist = root == B || left.visitedB || right.visitedB;

        if(a_exist && b_exist){
            return new ResultType(a_exist, b_exist, root);
        }
        if (left.curNode != null && right.curNode != null){
            return new ResultType(a_exist, b_exist, root);
        }
        if (left.curNode != null){
            return new ResultType(a_exist, b_exist, root.left);
        }
        if (right.curNode != null){
            return new ResultType(a_exist, b_exist, root.right);
        }

        return new ResultType(a_exist, b_exist, null);
    }
}
