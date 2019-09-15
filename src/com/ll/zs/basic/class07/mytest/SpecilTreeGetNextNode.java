package com.ll.zs.basic.class07.mytest;

/**
 * 有如下数据结构：
 * public class Node{
 *         private int val;
 *         private Node left;
 *         private Node right;
 *         private Node parent;
 *
 *         public Node(int val){
 *             this.val = val;
 *         }
 *     }
 * 该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设有一
 * 棵该Node节点组成的二叉树，树中每个节点的parent指针都正确指向自己的
 * 父节点，头节点的parent指向为null。只给一个在二叉树中的某个节点node,
 * 请实现返回node的后继节点的函数。在二叉树的中序遍历的序列中，node的
 * 下一个节点叫做node的后继节点。
 */
public class SpecilTreeGetNextNode {
    public class Node{
        private int val;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int val){
            this.val = val;
        }
    }

    //需要将情况分为所指的node有没有右子树的情况
    //如果该节点有右子树，那么结果为该节点的右子
    // 树上最左边的节点，即这里调用了getMostLeft
    //函数获取，如果没有右子树的话，应该从该节点
    // 向上寻找父节点，知道满足条件：该父节点为空，
    //或者该父节点的左孩子为该节点的后停止。
    public static Node getSuccessorNode(Node node){
        if(node == null){
            return node;
        }
        if(node.right != null){
            return getMostLeft(node.right);
        }else{
            Node parent = node.parent;
            while (parent != null && parent.left != node){
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getMostLeft(Node node){
        if(node == null){
            return node;
        }
        while (node.left != null){
            node = node.left;
        }
        return  node;
    }
}
