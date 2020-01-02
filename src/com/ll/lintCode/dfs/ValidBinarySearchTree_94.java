package com.ll.lintCode.dfs;

import com.ll.lintCode.utils.TreeNode;

public class ValidBinarySearchTree_94 {
    public class ResultType{
        public boolean is_bst;
        public int minVal;
        public int maxVal;

        public ResultType(boolean is_bst, int minVal, int maxVal){
            this.is_bst = is_bst;
            this.maxVal = maxVal;
            this.minVal = minVal;
        }
    }
    public boolean isValidBinarySearchTree(TreeNode root){
        if (root == null){
            return true;
        }
        return helper(root).is_bst;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);

        if(!leftRes.is_bst || !rightRes.is_bst){
            return new ResultType(false, -1, -1);
        }

        if((root.left != null && leftRes.maxVal >= root.val) || (root.right != null && rightRes.minVal <= root.val)){
            return new ResultType(false, -1, -1);
        }

        return new ResultType(true,
                    Math.min(root.val,leftRes.minVal),
                    Math.max(root.val,rightRes.maxVal));
    }

}
