package com.ll.leetcode;

import com.ll.utils.TreeNode;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 *  
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Flatten_114 {


    public void flatten(TreeNode root) {
        if(root == null) {
            return;
        }

        flattenRetRoot(root);
        System.out.println("finished");
    }

    private TreeNode flattenRetRoot(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = flattenRetRoot(root.left);
        TreeNode right = flattenRetRoot(root.right);
        TreeNode tmpNode = right;
        if(left != null) {
            root.right = left;
            root.left = null;
            if(right != null) {
                TreeNode curRight = left;
                while(curRight.right != null) {
                    curRight = curRight.right;
                }
                curRight.right = tmpNode;
            }
        }

        return root;
    }


    public static void main(String[] args) {
        TreeNode data = new TreeNode(1);
        data.left = new TreeNode(2);
        data.left.left = new TreeNode(3);
        data.left.right = new TreeNode(4);
        data.right = new TreeNode(5);
        data.right.right = new TreeNode(6);

        Flatten_114 dto = new Flatten_114();
        dto.flatten(data);

    }
}
