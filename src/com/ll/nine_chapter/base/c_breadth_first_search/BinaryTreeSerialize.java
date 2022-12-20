package com.ll.nine_chapter.base.c_breadth_first_search;

import com.ll.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeSerialize {

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public static String serialize(TreeNode root) {
        StringBuilder res = new StringBuilder();
        if(root == null) {
            return res.toString();
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode curNode = queue.poll();
                if(curNode == null) {
                    res.append("#");
                    res.append("-");
                    continue;
                } else {
                    res.append(curNode.val);
                }

                if(curNode.left != null) {
                    queue.add(curNode.left);
                } else {
                    queue.add(null);
                }
                if(curNode.right != null) {
                    queue.add(curNode.right);
                } else {
                    queue.add(null);
                }

                res.append("-");
            }
        }

        return res.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public static TreeNode deserialize(String data) {
        if(data.length() < 1) {
            return null;
        }

        String[] splits = data.split("-");
        int i = 1;
        TreeNode root = new TreeNode(Integer.parseInt(splits[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int j = 0; j < size; j++) {
                TreeNode curNode = queue.poll();
                TreeNode leftNode, rightNode;
                if("#".equals(splits[i])) {
                    leftNode = null;
                } else {
                    leftNode = new TreeNode(Integer.parseInt(splits[i]));
                    queue.add(leftNode);
                }
                curNode.left = leftNode;
                i += 1;

                if("#".equals(splits[i])) {
                    rightNode = null;
                } else {
                    rightNode = new TreeNode(Integer.parseInt(splits[i]));
                    queue.add(rightNode);
                }
                curNode.right = rightNode;
                i += 1;
            }
        }

        return  root;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        String res = serialize(root);
        System.out.println(res);

        root = deserialize(res);
    }

}
