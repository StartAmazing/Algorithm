package com.ll.lintcode.bfs;

import com.ll.lintcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal_69 {

    public List<List<Integer>> getBinaryTreeLevelOrderTraversal(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res){
        if(root == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            List<Integer> subRes = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i ++){
                TreeNode curNode = queue.poll();
                subRes.add(curNode.val);
                if(curNode.left != null){
                    queue.add(curNode.left);
                }
                if(curNode.right != null){
                    queue.add(curNode.right);
                }
            }
            res.add(subRes);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        BinaryTreeLevelOrderTraversal_69 dto = new BinaryTreeLevelOrderTraversal_69();
        List<List<Integer>> res = dto.getBinaryTreeLevelOrderTraversal(root);
        System.out.println(res.toString());

    }

}
