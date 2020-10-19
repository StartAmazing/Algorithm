package com.ll.zs.nowcoder.tree;

public class JudgeBalanceTree {
    public class Node{

        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static class ReturnData{
        public boolean isB;
        public int h;

        public ReturnData(boolean isB, int h){
            this.isB = isB;
            this.h = h;
        }
    }

    public static boolean isB(Node head){
        return process(head).isB;
    }

    public static ReturnData process(Node head){
        if(head == null){
            return new ReturnData(true, 0);
        }

        ReturnData leftData = process(head.left);
        if(!leftData.isB){
            return new ReturnData(false, 0);
        }
        ReturnData rightData = process(head.right);
        if(!rightData.isB){
            return new ReturnData(false, 0);
        }

        if(Math.abs(leftData.h - rightData.h) > 1){
            return new ReturnData(false, 0);
        }
        return new ReturnData(true, Math.max(leftData.h , rightData.h) + 1);
    }


}
