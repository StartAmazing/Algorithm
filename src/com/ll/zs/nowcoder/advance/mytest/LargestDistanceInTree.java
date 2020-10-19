package com.ll.zs.nowcoder.advance.mytest;

/**
 * 二叉树中，一个节点可以往上走和网下，那么节点A总能走到B
 * 节点A走到节点B的距离为：A走到B最短路径上的节点个数
 * 求一课二叉树上的远距离
 */
public class LargestDistanceInTree {

    public static class Node{
        public int val;
        public Node left;
        public Node right;

        public Node(int val){
            this.val = val;
        }

    }

    public static class ReturnType{
        public int maxDistance;
        public int h;

        public ReturnType(int maxDistance, int h){
            this.maxDistance = maxDistance;
            this.h = h;
        }

    }

    public static int getLargestDistance(Node head){
        if(head == null){
            return 0;
        }
        return process(head).maxDistance;
    }

    public static ReturnType process(Node head){
        if(head == null){
            return new ReturnType(0,0);
        }
        ReturnType leftData = process(head.left);
        ReturnType rightData = process(head.right);

        int p1 = leftData.maxDistance;
        int p2 = rightData.maxDistance;
        int includeSelf = leftData.h + rightData.h + 1;
        int resDistance = Math.max(Math.max(p1,p2), includeSelf);
        int h = Math.max(leftData.h, rightData.h);
        return new ReturnType(resDistance,h);
    }


}
