package com.ll.zs.tree;

/**
 * 得到一个完全二叉树的结点个数
 * 时间复杂度为O((log N)^2)
 */
public class NumOfNodeInCBT {

    public class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int data){
            this.value = data;
        }
    }

    public static int nodeNum(Node head){
        if(head == null )
            return 0;
        return bs(head, 1, mostLeftLevel(head, 1));
    }

    /**
     * @param node  当前结点
     * @param level 当前结点在第几层
     * @param h     固定的值，这棵树整个的深度
     * @return      以node结点为头的子树一共有多少个结点
     */
    private static int bs(Node node, int level, int h){
        if(level == h)
            return 1;
        //右子树的左边界到了哪一层并且和node结点最深的一层作比较
        //如果相等，那么说明node节点的左子树为满二叉树，高度为h-1，
        //如果不相等，说明node节点的右子树为满二叉树，高度为h-2
        if(mostLeftLevel(node.right, level + 1) == h){
            //1向左位移（h-level位）2的h-level次方
            return (1 << (h - level)) + bs(node.right, level + 1, h);
        }else{
            return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
        }
    }

    //因为题目已知条件是完全二叉树，所以此方法可以求出此完全二叉树的最大深度

    /**
     * @param node 当前结点
     * @param level 当前节点所在的层次
     * @return  该棵树的深度 + level - 1
     */
    private static int mostLeftLevel(Node node, int level){
        while(node != null){
            level++;
            node = node.left;
        }
        return level - 1;
    }


}
