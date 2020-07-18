package com.ll.lintcode.advance.chapter3.datastructre.stack;

import com.ll.lintcode.basic.utils.TreeNode;
import com.ll.zs.tree.Tree;

import java.util.Stack;

/**
 * 给出一个没有重复的整数数组，在此数组上建立最大树的定义如下：
 *
 * 根是数组中最大的数
 * 左子树和右子树元素分别是被父节点元素切分开的子数组中的最大值
 * 利用给定的数组构造最大树。
 *
 * 样例
 * 样例 1:
 *
 * 输入：[2, 5, 6, 0, 3, 1]
 * 输出：{6,5,3,2,#,0,1}
 * 解释：
 * 此数组构造的最大树是：
 *     6
 *    / \
 *   5   3
 *  /   / \
 * 2   0   1
 * 样例 2:
 *
 * 输入：[6,4,20]
 * 输出：{20,6,#,#,4}
 * 解释：
 *      20
 *      /
 *     6
 *      \
 *       4
 *
 * 挑战
 * 要求时间复杂度和空间复杂度均为O(n)
 */
public class MaxTree_126 {
    // 1. 找到左边第一个比他大的值
    // 2. 找到右边第一个比他大的值
    // 3. 1/2中找到最小值即为它的根节点
    public TreeNode maxTree(int[] A) {
        if (null == A) {
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;
        TreeNode[] ANode = new TreeNode[A.length];
        for (int i = 0; i < ANode.length; i++) {
            ANode[i] = new TreeNode(A[i]);
        }
        for (int i = 0; i < ANode.length + 1; i++) {
            TreeNode curNode = (i == ANode.length ? null : ANode[i]);
            while (!stack.isEmpty() && (curNode == null || curNode.val > stack.peek().val)) {
                if (curNode == null) {
                    if (stack.size() == 1) {
                        root = stack.pop();
                    } else {
                        TreeNode pop = stack.pop();
                        stack.peek().right = pop;
                    }
                } else {
                    TreeNode child = stack.pop();
                    TreeNode parent = curNode;
                    if (!stack.isEmpty() && stack.peek().val < parent.val) {
                        parent = stack.peek();
                        parent.right = child;
                    } else {
                        parent.left = child;
                    }

                }
            }
            if (i != ANode.length) {
                stack.push(ANode[i]);
            }
        }

        return root;
    }

}
