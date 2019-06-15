package com.ll.classdesign.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BSTForInteger {

    private Node root;  //二叉树的根结点
    private int size;   //二叉树的结点数量

    private class Node{
        public Integer val;
        public Node left, right;
        public int height;

        public Node(Integer data){
            this.val = data;
            left = null;
            right = null;
            height = 1;
        }
    }

    //二叉搜索树构造函数
    public BSTForInteger(){
        root = null;
        size = 0;
    }

    //返回二叉搜索搜索树的size
    public int getSize(){
        return size;
    }

    //判断二叉搜索树是否为一棵空树
    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树中添加一个Integer元素
    public void add(Integer value){
        root = add(root, value);
    }

    //向以node为根的二分搜索树中插入一个Integer元素，递归算法
    //返回插入新节点后二分搜索树的根
    private Node add(Node root, Integer value){
        if(root == null ) {
            size++;
            return new Node(value);
        }
        if(value > root.val){
            root.right = add(root.right, value);
        }else  if(value  < root.val){
            root.left = add(root.left, value);
        }else{  //value == root.value
               root.val = value;
        }

        //更新height
        root.height = 1 + Math.max(getNodeHeight(root.left), getNodeHeight(root.right));
        return root;
    }

    //返回以node为根结点的二分搜索树中，value所在的结点
    private Node getNode(Node root, Integer value){

        if(root == null) {
            System.out.println("No Element!");
            return null;
        }
        if(value == root.val){
            return root;
        }else if(value < root.val){
            return getNode(root.left, value);
        }else {
            return getNode(root.right, value);
        }
    }

    //判断二叉搜索树中是否包含值为value的元素
    public boolean isContains(Integer value){
        return getNode(root, value) != null;
    }

    //返回以node为根所在的二叉搜索树中最小值所在的结点
    private Node minimum(Node node){
        if(node.left == null){
            return node;
        }
        return minimum(node.left);
    }

    public Node remove(int value){
        Node node = getNode(root, value);
        if(node != null){
            root = remove(root, value);
            return node;
        }
        return null;
    }

    //从二分搜索树中删除值为value的结点
    private Node remove(Node root, int value){
        if(root == null)
            return null;
        Node retNode;
        if(getNode(root,value) == null){
            return null;
        }
        if(root.val > value){
            root.left = remove(root.left, value);
            retNode = root;
        }else if(root.val < value){
            root.right = remove(root.right, value);
            retNode = root;
        }else{  //node.val == value
            //待删除结点 左子树为空的情况
            if(root.left == null){
                Node rightNode = root.right;
                root.right = null;
                size -- ;
                retNode = rightNode;
            }
            //待删除结点右子树为空的情况
            else if(root.right == null){
                Node leftNode = root.left;
                root.left = null;
                size --;
                retNode = leftNode;
            }else {
                //待删除左右子树均不为空的情况

                //找到比待删除结点大的最小结点，即待删除结点右子树的最小结点
                //用这个结点顶替待删除节点位置
                Node successor = minimum(root.right);
                successor.right = remove(root.right, successor.val);
                successor.left = root.left;
                root.left = root.right = null;
                 retNode = successor;
            }
        }
        if(retNode == null)
            return null;

        //更新height
        retNode.height = 1 + Math.max(getNodeHeight((retNode.left)),getNodeHeight(retNode.right));

        return retNode;
    }
    //先序遍历
    public void preOrderTravel(Node root){
        if(root == null)
            return;
        System.out.print(" " + root.val);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    //中序遍历
    public void inOrderTravel(Node root){
        if(root == null)
            return;
        inOrderTravel(root.left);
        System.out.print(" " + root.val);
        inOrderTravel(root.right);
    }

    //后序遍历
    public void postOrderTravel(Node root){
        if(root == null)
            return;
        postOrderTravel(root.left);
        postOrderTravel(root.right);
        System.out.print(" " + root.val);
    }
    //广度优先遍历二叉搜索树
    public void tierTravel(Node root){
        if(root == null)
            return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            System.out.print(" " + node.val);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
    //计算第n层的所有兄弟元素
    //利用按层序列化
    public Queue<Integer> getTierBroElement(int n, Node root){
        Queue<Integer> res = new LinkedList<>();
        Queue<Integer> q = serialByTier(root);

        int start = (int) (Math.pow(2, n-1)) - 1;
        int end = (int) (Math.pow(2, n)) - 2;
        for(int i = 0; i < start; i++){
            q.poll();
        }
        for(int i = 0; i <= end - 2 ; i++){
            res.add(q.poll());
        }
        //清除队列中为-1的元素
        Queue<Integer> q2 = new LinkedList<>();
        while(!res.isEmpty()){
            if(res.peek() != -1){
                q2.add(res.poll());
            }else
                res.poll();
        }
        return q2;
    }
    //序列化
    private Queue<Integer> serialByTier(Node root){
        if(root == null) return null;
        Queue<Integer> res= new LinkedList<>();
        res.add(root.val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(!queue.isEmpty() && count <= getDepth(root)){
            Node node = queue.poll();
            count += 1;
            if(node.left != null){
                queue.add(node.left);
                res.add(node.left.val);
            }else {
                queue.add(new Node(-1));
                res.add(-1);
            }
            if(node.right != null){
                queue.add(node.right);
                res.add(node.right.val);
            }else {
                queue.add(new Node(-1));
                res.add(-1);
            }
        }
        return res;
    }

    //计算二叉树的深度
    public int getDepth(Node root){
        return root.height - 1;
    }
    //计算二叉树某个结点的高度
    public int getNodeHeight(Node node){
       if(node == null) {
           return -1;
       }
       return node.height;
    }

    public static void main(String[] args) {
        BSTForInteger bstForInteger = new BSTForInteger();
        Integer[] arr = {45 , 12, 53, 3, 37, 24, 100, 61, 90, 78};
        for(Integer i : arr){
            bstForInteger.add(i);
        }

        System.out.println("preOrder: ");
        bstForInteger.preOrderTravel(bstForInteger.root);
        System.out.println();
        System.out.println("inOrder： ");
        bstForInteger.inOrderTravel(bstForInteger.root);
        System.out.println();
        System.out.println("postOrder: ");
        bstForInteger.postOrderTravel(bstForInteger.root);
        System.out.println();
        System.out.println("tierOrder: ");
        bstForInteger.tierTravel(bstForInteger.root);
        //测试二叉树的深度
        System.out.println();
        System.out.println("此时二叉树的深度为： " + bstForInteger.getDepth(bstForInteger.root));
        System.out.println();
        int value = 90;
        System.out.println("二叉树中值为"+ value +"的结点高度为： " + bstForInteger.getNodeHeight(bstForInteger.getNode(bstForInteger.root,value)));
        System.out.println();

        System.out.println();
        System.out.println(bstForInteger.serialByTier(bstForInteger.root));

        System.out.println("第三层的兄弟结点为：");
        Queue<Integer> queue = bstForInteger.getTierBroElement(3, bstForInteger.root);
        queue.forEach(q-> System.out.print(q + " "));
        System.out.println();


        bstForInteger.add(21);
        bstForInteger.add(9);
        bstForInteger.add(55);
        System.out.println("new inorder: ");
        bstForInteger.inOrderTravel(bstForInteger.root);

        bstForInteger.remove(37);
        bstForInteger.remove(61);
        System.out.println();
        System.out.println("new inorder: ");
        bstForInteger.inOrderTravel(bstForInteger.root);

        System.out.println("======获取结点值为24信息=====");
        Node node = bstForInteger.getNode(bstForInteger.root, 24);
        System.out.println("结点val为24的值为：" + node.val);
        System.out.println("高度为" + node.height);
        System.out.println("左孩子为： "+node.left);
        System.out.println("右孩子为： "+node.right);


    }
}
