package com.ll.zs.tree;

import java.util.LinkedList;
import java.util.Queue;

//介绍二叉树的序列化和反序列化
public class SerializeAndReconstructTree {

    public static class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //先序遍历的序列化过程，中序、后序遍历类似
    public static String serialByPre(Node head){
        if(head == null)
            return "#!";
        String res = head.value + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);

        return res;
    }

    public static Node reconByPreString(String preStr){
        String[] values = preStr.split("!");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i != values.length; i++){
            //offer添加一个元素并返回true,如果队列已满返回false但是不会抛出异常
            queue.offer(values[i]);
        }
        return reconPreOrder(queue);
    }

    //给出一个队列，用它来生成一棵二叉树
    private static Node reconPreOrder(Queue<String> queue){
        String value = queue.poll();
        //如果当前的String是一个空值符号，那么返回null
        if(value.equals("#")){
            return null;
        }
        Node head = new Node(Integer.valueOf(value));
        head.left = reconPreOrder(queue);
        head.right = reconPreOrder(queue);
        return head;
    }
}
