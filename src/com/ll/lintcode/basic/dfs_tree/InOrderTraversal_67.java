package com.ll.lintcode.basic.dfs_tree;

import com.ll.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InOrderTraversal_67 {

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
        TreeNode helpRoot = root;
        while (!stack.isEmpty() || helpRoot != null){
            if(helpRoot != null){
                stack.add(helpRoot);
                helpRoot = helpRoot.left;
            }else{
                helpRoot = stack.pop();
                res.add(helpRoot.val);
                helpRoot = helpRoot.right;
            }
        }

        return  res;
    }

}
