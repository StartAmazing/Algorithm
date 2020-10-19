package com.ll.zs.nowcoder.tree;

public class PrecursorNode {

    public static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int data){
            this.value = data;
        }
    }

    public static Node getPrecursor(Node node){
        if(node == null)
            return node;
        if(node.left != null){
            return getRightMost(node.left);
        }
        else {
            Node parent = node.parent;
            while (parent != null && parent.right != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    private static Node getRightMost(Node node){
        if(node == null)
            return node;
        while(node.right != null){
            node = node.right;
        }
        return node;
    }

}
