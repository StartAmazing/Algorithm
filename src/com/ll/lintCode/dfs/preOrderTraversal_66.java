package com.ll.lintCode.dfs;

import com.ll.lintCode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class preOrderTraversal_66 {

    //1. traverse
    public List<Integer> getBinaryPreOrderTra(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> leftRes = getBinaryPreOrderTra(root.left);
        List<Integer> rightRes = getBinaryPreOrderTra(root.right);

        res.add(root.val);
        res.addAll(leftRes);
        res.addAll(rightRes);

        return res;
    }

    //2. divide conquer
    public List<Integer> getBinaryPreOrderDiv(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        res.add(root.val);
        helper(root.left,res);
        helper(root.right,res);
    }

    //3. non-recursion
    public List<Integer> getBinaryPreOrderNonRec(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        if(root != null){
            stack.add(root);
        }
        while (!stack.isEmpty()){
            TreeNode curNode = stack.pop();
            res.add(curNode.val);
            if(curNode.right != null){
                stack.add(curNode.right);
            }
            if(curNode.left != null){
                stack.add(curNode.left);
            }
        }
        return res;
    }

}
