package com.ll.zs.advance.advanced_class_01.mytest;

/**
 * 单调栈
 * 构造数组的MaxTree
 * 定义一个二叉树节点如下
 * 一个数组的MaxTree定义如下，
 * 1. 数组必须没有重复元素
 * 2. MaxTree是一颗二叉树，数组的每一个值对应一个二叉树节点
 * 3. 包括MaxTree树在内且在其中的每一颗子树上，值最大的节点都是树的头
 * 4. 有重复元素的数组arr,写出生成这个数组的MaxTree的函数，要求如果数组长度为N，则时间复杂度为O(N)
 *  空间复杂度为O(N)
 *
 *  解法一： 将数组改造成一个大根堆
 *  解法二： 单调栈
 */
class Node{
    public int value;
    public Node left;
    public Node right;

    public Node(int data){
        this.value = data;
    }
}

public class MaxTree {
}
