package com.ll.lintcode.basic.dfs_tree;

import com.ll.lintcode.basic.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class inOrderTraversal_67 {

    //1. traverse
    public List<Integer> getBinaryInOrderTraversalTra(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        List<Integer> leftVals = getBinaryInOrderTraversalTra(root.left);
        List<Integer> rightVals = getBinaryInOrderTraversalTra(root.right);

        res.addAll(leftVals);
        res.add(root.val);
        res.addAll(rightVals);

        return res;
    }

    //2.divide conquer
    public List<Integer> getBinaryInOrderTraversalDiv(TreeNode root){
        List<Integer> res = new ArrayList<>();
        helper(root,res);
        return res;
    }

    private void helper(TreeNode root, List<Integer> res){
        if(root == null){
            return;
        }
        helper(root.left,res);
        res.add(root.val);
        helper(root.right,res);
    }

    //3. non-recursion
    public List<Integer> getBinaryInOrderTraversalNonRec(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null){
            if(root != null){
                stack.add(root);
                root = root.left;
            }else{
                root = stack.pop();
                res.add(root.val);
                root = root.right;
            }
        }

        return  res;
    }

}
