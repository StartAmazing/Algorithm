package com.ll.zs.basic.class07.mytest;

import com.ll.zs.sort.HeapSort;

import java.util.Stack;

public class TreeTraverse {
    public class Node{
        private int val;
        private Node rightNode;
        private Node leftNode;

        public Node(int val){
            this.val = val;
        }
    }

    private static void preOderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print("head.data: " + head.val + " ");
        preOderRecur(head.rightNode);
        preOderRecur(head.leftNode);
    }

    private static void inOrderRecur(Node head){
        if(head == null){
            return;
        }
        inOrderRecur(head.leftNode);
        System.out.print("head data: " + head.val + " ");
        inOrderRecur(head.rightNode);
    }

    private static void postOrderRecur(Node head){
        if(head == null){
            return;
        }
        postOrderRecur(head.leftNode);
        postOrderRecur(head.rightNode);
        System.out.print("head data: " + head.val + " ");
    }

    //中左右
    private static void preOrderUnRecur(Node head){
        System.out.println("pre-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.print("head data: " + head.val);
                if(head.rightNode != null){
                    stack.push(head.rightNode);
                }
                if(head.leftNode != null){
                    stack.push(head.leftNode);
                }
            }
        }
        System.out.println();
    }

    //左中右
    private static  void inOrderUnRecur(Node head){
        System.out.print("in-order: ");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while (!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.leftNode;
                }else {
                    head = stack.pop();
                    System.out.print("head data: " + head.val + " ");
                    head = head.rightNode;
                }

            }
        }
        System.out.println();
    }

    //左右中   =>  中右左
    private static void postOrderUnRecur(Node head){
        System.out.println("post-order: " );
        if(head != null){
            Stack<Node> stack = new Stack<>();
            Stack<Node> help = new Stack<>();
            stack.push(head);
            while(!stack.isEmpty()){
                help.push(stack.pop());
                if(head.leftNode != null){
                    stack.push(head.leftNode);
                }
                if(head.rightNode != null){
                    stack.push(head.rightNode);
                }
            }
            while (!help.isEmpty()){
                System.out.print("head data: " + help.pop() + " ");
            }
        }
    }
}
