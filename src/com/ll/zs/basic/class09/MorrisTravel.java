package com.ll.zs.basic.class09;

public class MorrisTravel {

    public static class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    public static void morris0(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){   //任何一个有左子树的树的最右节点 要么指向空要么指向cur1
                    cur2 = cur2.right;
                }
                if(cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public static void morris(Node head){
        if(head == null){
            return;
        }
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null) {
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }
            cur1 = cur1.right;
        }
    }

    public static void mirrosPre(Node head){
        if(head == null) return;
        Node cur1 = head;
        Node cur2 = null;
        while(cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    System.out.print(cur1.val + " ");
                    cur1 = cur1.left;
                    continue;
                }else {
                    cur2.right = null;
                }
            }else {
                System.out.print(cur1.val + " ");
            }
            cur1 = cur1.right;
        }
        System.out.println();
    }

    public static void mirrosIn(Node head){
        if(head == null ) return;
        Node cur1 = head;
        Node cur2 = null;
        while (cur1 != null){
            cur2 = cur1.left;
            if(cur2 != null){
                while (cur2.right != null && cur2.right != cur1){
                    cur2 = cur2.right;
                }
                if(cur2.right == null){
                    cur2.right = cur1;
                    cur1 = cur1.left;
                    continue;
                }else{
                    cur2.right = null;
                }
            }
            System.out.print(cur1.val + " ");
            cur1 = cur1.right;

        }
        System.out.println();
    }

    public static void morrisPos(Node head){
         if(head == null) return;
         Node cur1 = head;
         Node cur2 = null;
         while (cur1 != null){
             cur2 = cur1.left;
             if(cur2 != null){
                 while (cur2.right != null && cur2.right != cur1){
                     cur2 = cur2.right;
                 }
                 if(cur2.right == null){
                     cur2.right = cur1;
                     cur1 = cur1.left;
                     continue;
                 }else{
                     cur2.right = null;
                     printRightEdge(cur1.left); //第二次来到有左子树额节点时逆序打印该节点对应的右边界
                 }
             }
             cur1 = cur1.right;
         }
         printRightEdge(head);     //逆序打印整个树的右边界
    }


    private static void printRightEdge(Node root){
        Node tail = reverseEdge(root);
        Node pre = tail;
        while (pre != null){
            System.out.print(pre.val + " ");
            pre = pre.right;
        }
        reverseEdge(tail);

    }

    private static Node reverseEdge(Node from){
        Node pre = null;
        Node next = null;
        while (from != null){
            next = from.right;
            from.right = pre;
            pre = from;
            from = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.left.right.left = new Node(6);
        root.left.right.right = new Node(7);
        root.right = new Node(3);

        mirrosIn(root);
        System.out.println("==========");
        mirrosPre(root);
        System.out.println("==========");
        morrisPos(root);
    }

}
