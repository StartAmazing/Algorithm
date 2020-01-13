package com.ll.lintCode.dfs_tree;

import com.ll.lintCode.utils.TreeNode;

//最近公共祖先节点
public class LowestCommonAncestor_1311 {

    public class ResultType{
        public boolean visitA;
        public boolean visitB;
        public TreeNode lca;
        public ResultType(boolean visitA, boolean visitB, TreeNode lca){
            this.visitA = visitA;
            this.visitB = visitB;
            this.lca = lca;
        }
    }

    //1. ResultType
    public TreeNode getLowestCommonAncestorRes(TreeNode root, TreeNode p1, TreeNode p2){
        if(root == null){
            return null;
        }
        return helper(root,p1, p2).lca;
    }

    private ResultType helper(TreeNode root, TreeNode p1, TreeNode p2){
        if(root == null){

            return new ResultType(false,false,root);
        }

        if(root == p1 && root == p2){
            return new ResultType(true,true,root);
        }

        ResultType leftNode = helper(root.left, p1, p2);
        ResultType rightNode = helper(root.right, p1, p2);

        if(leftNode.visitA && leftNode.visitB){
            return leftNode;
        }

        if(rightNode.visitA && rightNode.visitB){
            return rightNode;
        }

        if((leftNode.visitA && rightNode.visitB) || (leftNode.visitB && rightNode.visitA)){
            return new ResultType(true,true, root);
        }

        if(leftNode.visitA || rightNode.visitA){
            if(root == p2){
                return new ResultType(true,true,root);
            }
            return new ResultType(true,false, root);
        }

        if(leftNode.visitB || rightNode.visitB){
            if(root == p1){
                return new ResultType(true,true,root);
            }
            return new ResultType(false,true, root);
        }

        if(root == p1 || root == p2){
            if(root == p1){
                return new ResultType(true, false,root);
            }else{
                return new ResultType(false, true,root);
            }
        }

        return new ResultType(false,false,root);
    }

    //2. traverse
    public TreeNode getLowestCommonAncestorTra(TreeNode root, TreeNode p1, TreeNode p2){
        if(root == null || root == p1 || root == p2){
            return  root;
        }

        TreeNode leftRes = getLowestCommonAncestorTra(root.left, p1, p2);
        TreeNode rightRes = getLowestCommonAncestorTra(root.right, p1, p2);

        if(leftRes != null && rightRes != null){
            return root;
        }

        if(leftRes != null){
            return leftRes;
        }

        if(rightRes != null){
            return rightRes;
        }

        return null;
    }
}
