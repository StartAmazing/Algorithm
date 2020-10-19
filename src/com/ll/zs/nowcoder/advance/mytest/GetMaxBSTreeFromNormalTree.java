package com.ll.zs.nowcoder.advance.mytest;

/**
 * 给定一个二叉树的头结点head,请返回最大搜索
 * 二叉搜索子树的大小
 */
public class GetMaxBSTreeFromNormalTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;;
        }
    }

    public static class ReturnData{
        public int max;
        public int min;

        public ReturnData(int max ,int min){
            this.max = max;
            this.min = min;
        }
    }

    public static void printMinAndMax(Node head){
        ReturnData data = p(head);
        System.out.println("min : " + data.min + "\n max: " + data.max);
    }

    public static ReturnData p(Node head){
        if(head == null){
            return new ReturnData(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        ReturnData leftData = p(head.left);
        ReturnData rightData = p(head.right);

        return new ReturnData(Math.max(Math.max(leftData.max, rightData.max)
                ,head.value),Math.min(Math.min(leftData.min, rightData.min),head.value));
    }


    public static class ReturnType{
        public int size;
        public Node head;
        public int min;
        public int max;

        public ReturnType(int a,Node b, int c, int d){
            this.size = a;      //子二叉搜索树的最大size
            this.head = b;      //子二叉搜索树返回的头结点
            this.min = c;   //子树中的小值
            this.max = d;   //子树中的最大值
        }

//        public static Node biggestSubBST(Node head){
//            int[] record = new int[3];  // 0 -> size, 1 -> min, 2 -> max
//            return posOrder(head,record);
//        }

        public static ReturnType process(Node head){
            if(head == null){
                return new ReturnType(0,null,Integer.MAX_VALUE,Integer.MIN_VALUE);
            }
            Node left = head.left;
            ReturnType leftSubTressInfo = process(left);
            Node right = head.right;
            ReturnType rightSubTressInfo = process(right);

            int includeItSelf = 0;
            if(leftSubTressInfo.head == left
                && rightSubTressInfo.head == right
                && head.value > leftSubTressInfo.max
                && head.value < rightSubTressInfo.min){
                includeItSelf = leftSubTressInfo.size + 1 + rightSubTressInfo.size;
            }

            int p1 = leftSubTressInfo.size;
            int p2 = rightSubTressInfo.size;
            int maxSize = Math.max(Math.max(p1, p2), includeItSelf);

            Node maxHead = p1 > p2 ? leftSubTressInfo.head : rightSubTressInfo.head;
            if(maxSize == includeItSelf){
                maxHead = head;
            }

            return new ReturnType(maxSize, maxHead,
                    Math.min(Math.min(leftSubTressInfo.min,rightSubTressInfo.min),head.value),
                    Math.max(Math.max(leftSubTressInfo.max,rightSubTressInfo.max),head.value));
        }


    }

}
