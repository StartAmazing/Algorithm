package com.ll.muke.map;

import com.ll.muke.set.FileOperation;

import java.util.ArrayList;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>{

    private class Node{
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value){
        if(node == null){
            size ++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key) < 0){
            node.left = add(node.left, key, value);
        }else if(key.compareTo(node.key) > 0){
            node.right = add(node.right, key, value);
        }else{
            node.value = value;
        }

        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //删除掉以node为根的二分搜索树中key值为key的结点，递归算法
    //返回删除节点后新的二叉树的根结点
    private Node remove(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) < 0){
            node.left = remove(node.left, key);
            return node;
        }else if(key.compareTo(node.key) > 0){
            node.right = remove(node.right, key);
            return node;
        }else{  //e.compareTo(node.e) == 0

            //待删除结点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size -- ;
                return rightNode;
            }

            //待删除结点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            //待删除结点左右子树都不为空的情况
            Node successor = minmum(node.right); //找到要删除结点右子树中最小节点
            successor.right = removeMin(node.right);    //删除掉结点右子树中最小结点并且返回这个右子树的根结点，总体上来看是当前操作结点的右子树的根结点
            successor.left = node.left; //将新节点的左孩子指向当前节点的左孩子

            return successor;
        }
    }


    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if(node == null){
            throw new IllegalArgumentException(key + " doesn't exist!");
        }else{
            node.value = newValue;
        }

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    //返回以node为根结点的二分搜索树中，key所在的结点
    private Node getNode(Node node, K key){
        if(node == null){
            return null;
        }
        if(key.compareTo(node.key) == 0){
            return node;
        }else if(key.compareTo(node.key) < 0){
            return getNode(node.left, key);
        }else{
            return getNode(node.right, key);
        }

    }

    //返回以node为根的二分搜索树为根的最小值所在的结点
    private Node minmum(Node node){
        if(node == null){
            return null;
        }
        return minmum(node.left);
    }

    //删除掉以node为根的二分搜索树中的最小结点
    //返回删除结点后新的二分搜索树的根
    private Node removeMin(Node node){
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //返回以node为根的二分搜索树为根的最大值所在的结点
    private Node maxmum(Node node){
        if(node == null){
            return null;
        }
        return maxmum(node.right);
    }

    //删除掉以node为根结点的二分搜索树中的最大结点
    //返回删除结点后新的二叉搜索树的根
    private Node removeMax(Node node){
        if(node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.left = removeMin(node.right);
        return node;
    }

    public static void main(String[] args){
        System.out.println("pride and prejudice");

        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile("C:\\Users\\Administrator\\Workspaces\\IDEA\\Algorithm\\src\\pride-and-prejudice.txt",words)){
            System.out.println("total words: " + words.size());

            BSTMap<String, Integer> map = new BSTMap<>();
            for(String str: words){
                if(map.contains(str))
                    map.set(str,map.get(str) + 1);
                else
                    map.add(str, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }
    }
}
