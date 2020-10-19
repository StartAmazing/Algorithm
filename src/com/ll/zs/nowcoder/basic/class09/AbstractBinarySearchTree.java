package com.ll.zs.nowcoder.basic.class09;


public class AbstractBinarySearchTree {

    /** Root node where whole tree starts. */
    public Node root;

    /** tree size*/
    protected int size;

    protected Node createNode(Integer value, Node parent, Node left, Node right){

        return new Node(value,parent,left,right);
    }

    /**
     * Search ele from the tree
     * @param element The target ele
     * @return
     */
    public Node search(int element){
        Node node = root;
        while (node != null && node.val != null && node.val != element){
            if(element < node.val){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        return node;
    }

    public Node insert(int element){
        if(root == null){
            root = new Node(element);
            size ++ ;
            return root;
        }
        Node insertParentNode = null;
        Node searchTempNode = root;
        while (searchTempNode != null && searchTempNode.val != null){
            insertParentNode = searchTempNode;  //用来记录为空之前一个不为空的节点
            if(searchTempNode.val < element){
                searchTempNode = searchTempNode.right;
            }else{
                searchTempNode = searchTempNode.left;
            }
        }

        Node newNode = createNode(element,insertParentNode,null,null);
        if(insertParentNode.val > newNode.val){
            insertParentNode.left  = newNode;
        }else{
            insertParentNode.right = newNode;
        }
        size ++;
        return newNode;
    }

}
