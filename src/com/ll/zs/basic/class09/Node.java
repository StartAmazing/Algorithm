package com.ll.zs.basic.class09;

public class Node{

    public Node left;
    public Node right;
    public Integer val;

    public Node(Integer val){
        this.val = val;
    }

    public Node(Integer val,Node parent, Node left, Node right){
        this.val = val;
        if(this.val < parent.val){
            parent.left = this;
        }else if(this.val > parent.val){
            parent.right = this;
        }else{
            parent = this;
        }
        this.left = left;
        this.right = right;
    }

}
