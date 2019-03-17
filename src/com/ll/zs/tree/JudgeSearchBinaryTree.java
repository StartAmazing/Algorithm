package com.ll.zs.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//判断这棵树是否为完全二叉树以及这棵树是否为二叉搜索树
public class JudgeSearchBinaryTree {

    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    //判断是否为二叉搜索树
    public boolean isBST(Node node){
        ArrayList<Integer> list = new ArrayList<>();
        inOrder(node, list);
        for(int i = 1; i < list.size(); i++){
            if(list.get(i) < list.get(i - 1)){
                return false;
            }
        }
        return true;
    }

    //中序遍历（递归）
    private void inOrder(Node node, ArrayList<Integer> list){
        if(node == null){
            return;
        }
        inOrder(node.left, list);
        list.add(node.value);
        inOrder(node.right, list);
    }

    //非递归判断一课树是否为二叉搜索树（依靠中序遍历的非递归算法）
    public static boolean inOrderUnRecur(Node head){
        if(head == null)
            return true;
        else{
            Stack<Node> stack = new Stack<>();
            while( !stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    if(stack.peek() != null && head.value > stack.peek().value){
                        return false;
                    }
                    head = head.right;
                }
            }
        }
        return true;
    }

    //非递归判断一棵树是否为二叉搜索树
    public static boolean isBST2(Node node){
        if(node == null)
            return true;
        boolean res = true;
        Node pre = null;
        Node cur1 = node;
        Node cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while(cur2.right != null && cur2.right != cur1) {
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                        cur2.right = cur1;
                        cur1 = cur1.left;
                        continue;
                }else { //cur2.right != null
                        cur2.right = null;
                }
            }
            if(pre != null && pre.value > cur1.value){
                res = false;
            }
            pre = cur1;
            cur1 = cur1.right;
        }
        return res;
    }

    //判断棵树是否为完全二叉树
    public static boolean isCBT(Node node){
        if(node == null)
            return true;
        Queue<Node> queue = new LinkedList<>();
        Node l = null;
        Node r = null;
        queue.offer(node);
        boolean leaf = false;
        while(!queue.isEmpty()){
            node = queue.poll();
            l = node.left;
            r = node.right;
            if( (leaf && (l != null || r != null) || (l == null) && (r != null))){
                return false;
            }
            if(l != null){
                queue.offer(l);
            }

            /**
             * 如果一个结点不是两个孩子都有值，则他后面的结点必须全部为叶子结点
             * 换句话说，除非这里的左右子树都有值，否则之后的结点必须全为叶子节点
             * 不过在这之前，左无值，右有值已经直接return false了
             */
            if(r != null){
                queue.offer(r);
            }else{
                leaf = true;
            }
        }
        return true;
    }
}
