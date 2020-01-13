package com.ll.lintCode.dfs_tree;

import com.ll.lintCode.utils.DoublyListNode;
import com.ll.lintCode.utils.TreeNode;

public class ConvertBinarySearchTree2DoublyLinkedList_x {

    //with resultType
    public class ResultType{
        public DoublyListNode first;
        public DoublyListNode last;
        public ResultType(DoublyListNode first, DoublyListNode last){
            this.first = first;
            this.last = last;
        }
    }

    public DoublyListNode convertBinaryTree2DoublyLinkedList(TreeNode root){
        if(root == null){
            return null;
        }
        return helper(root).first;
    }

    private ResultType helper(TreeNode root){
        if(root == null){
            return new ResultType(null, null);
        }

        ResultType leftNode = helper(root.left);
        ResultType rightNode = helper(root.right);

        DoublyListNode node = new DoublyListNode(root.val);

        ResultType result = new ResultType(null, null);

        if(leftNode == null){
            result.first = node;
        }else{
            result.first = leftNode.first;
            leftNode.last.next = node;
            node.prev = leftNode.last;
        }

        if(rightNode == null){
            result.last = node;
        }else{
            result.last = rightNode.last;
            node.next = rightNode.first;
            rightNode.first.prev = node;
        }

        return result;
    }
}
