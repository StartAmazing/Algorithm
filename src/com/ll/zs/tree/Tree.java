package com.ll.zs.tree;

import java.util.Stack;

public class Tree {

    public class Node{

        public int data;
        public Node left;
        public Node right;

        public Node(int val){
            this.data = val;
        }
    }

    //Recursion PreOrder Traversal
    public static void preOrderRecur(Node head){
        if(head == null){
            return;
        }
        System.out.print(head.data + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //Recursion, InOrder Traversal
    public static void inOrderRecur(Node head){
        if(head == null)
            return;
        inOrderRecur(head.left);
        System.out.println(head.data + " ");
        inOrderRecur(head.right);
    }

    //Recursion, PostOrder Traversal
    public static void posOrderRecur(Node head){
        if(head == null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.println(head.data + " ");
    }

    //UnRecursion, PreOrder Traversal Additional used a Stack
    public static void preOrderUnrecur(Node head){
        System.out.println("pre-order: ->");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            stack.add(head);
            while(!stack.isEmpty()){
                head = stack.pop();
                System.out.println(head.data + "  ");
                if(head.right != null){
                    stack.push(head.right);
                }
                if(head.left != null){
                    stack.push(head.left);
                }
            }
        }
        System.out.println();
    }

    //Unrecursion, InOrder Traversal, Additional used a Stack
    public void InOrderUnRecur(Node head){
        System.out.println("in-order: ->");
        if(head != null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty() || head != null){
                if(head != null){
                    stack.push(head);
                    head = head.left;
                }else{
                    head = stack.pop();
                    System.out.println(head.data + " ");
                    head = head.right;
                }
            }
        }
        System.out.println();
    }

    //Unrecursion, PostOrder ,Additional used two Stacks
    public static void posOrderUnRecur(Node head){
        System.out.println("post-order: ->");
        if(head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            s1.push(head);
            while(!s1.isEmpty()){
                head = s1.pop();
                s2.push(head);
                if(head.left!=null){
                    s1.push(head.left);
                }
                if(head.right!=null){
                    s1.push(head.right);
                }
            }
            while(!s2.isEmpty()){
                System.out.println(s2.pop().data + " ");
            }
        }
        System.out.println();
    }

    //PostOrder,UnRecursion, Just Additional userd one Stack
    public static void posOrderUnRecur2(Node head){
        System.out.println("post-order :");
        if(head != null){
            Stack<Node> stack = new Stack<Node>();
            stack.push(head);
            Node c = null;
            while(!stack.isEmpty()){
                c = stack.peek();
                if(c.left != null && head != c.left && head != c.right)
                    stack.push(c.left);
                else if(c.right != null && head != c.right)
                    stack.push(c.right);
                else{
                    System.out.println(stack.pop().data + " ");
                    head = c;
                }
            }
        }
        System.out.println();
    }
}
