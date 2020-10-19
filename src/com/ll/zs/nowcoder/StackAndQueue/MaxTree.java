package com.ll.zs.nowcoder.StackAndQueue;

//构造数组的MaxTree

import java.util.HashMap;
import java.util.Stack;

/**
 * 定义二叉树结点如下：
 *
 * public static Node{
 *     public int value;
 *     public Node left;
 *     public Node right;
 *
 *     publi Node(int data){
 *         this.value = data;
 *     }
 * 一个数组的MaxTree定义如下
 *      数组必须没有重复元素
 *      MaxTree是一棵二叉树，数组的每一个值对应一个二叉树结点
 *      包括MaxTree树在内且在其中的每一棵子树上，值最大的结点都是树的头
 * 给定一个没有重复元素的数组arr,写出生成这个数组的MaxTree的函数，要求如果数组长度为N,则时间复杂度为O(N)、额外空间复杂度为O(N)
 * 例如：
 *      arr = {3,4,5,1,2}
 *      3左边的第一个比3大的数：无  3右边第一个比3大的数：4
 *      4左边的第一个比4大的数：无  4右边第一个比4大的数：5
 *      5左边的第一个比5大的数：无  5右边第一个比5大的数：无
 *      1左边的第一个比1大的数：5  1右边第一个比1大的数：2
 *      2左边的第一个比2大的数：5  2右边第一个比2大的数：无
 * 使用以下原则来建立这棵树：
 * 1、每一个数的父节点是它左边第一个比他大的数和他右边第一个比他大的数中，较小的那个
 * 2、如果一个数的左边没有比它大的数，右边也没有，也就是说，这个数是整个数组的最大值，那么这个数就是MaxTree的头结点
 *
 */

public class MaxTree {
    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map){
        Node popNode = stack.pop();
        if(stack.isEmpty()){
            map.put(popNode,null);
        }else{
            map.put(popNode, stack.peek());
        }
    }

    public static Node getMaxTree(int[] arr){
        Node[] nArr = new Node[arr.length];
        for(int i = 0; i < arr.length; i++){
            nArr[i] = new Node(arr[i]);
        }
        Stack<Node> stack = new Stack<Node>();
        HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
        HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
        for(int i = 0; i != nArr.length; i++){
            Node curNode = nArr[i];
            while(!stack.isEmpty() && stack.peek().value < curNode.value){
                popStackSetMap(stack,lBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack,lBigMap);
        }

        for(int i = nArr.length - 1; i != -1; i--){
            Node curNode = nArr[i];
            while((!stack.isEmpty()) && stack.peek().value < curNode.value){
                popStackSetMap(stack,rBigMap);
            }
            stack.push(curNode);
        }
        while(!stack.isEmpty()){
            popStackSetMap(stack, rBigMap);
        }
        Node head = null;
        for(int i = 0; i != nArr.length; i++){
            Node curNode = nArr[i];
            Node left = lBigMap.get(curNode);
            Node right = rBigMap.get(curNode);
            if(left == null && right == null){
                head =curNode;
            }else if(left == null){
                if(right.left == null){
                    right.left = curNode;
                }else{
                    right.right = curNode;
                }
            }else if(right == null){
                if(left.left == null){
                    left.left = curNode;
                }else{
                    left.right = curNode;
                }
            }else{
                Node parent = left.value < right.value ? left : right;
                if(parent.left == null){
                    parent.left = curNode;
                }else{
                    parent.right = curNode;
                }
            }
        }
        return head;
    }

}
