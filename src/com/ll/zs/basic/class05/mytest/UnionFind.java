package com.ll.zs.basic.class05.mytest;

import com.sun.org.apache.bcel.internal.generic.INEG;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 * 1. 判断两个元素是否在同一个集合
 * 2. 将两个元素所在的集合合并到一个集合
 */
public class UnionFind {
    public static class Node{
        //whatever you like is ok,such as: String/int/char/float...
    }

    public static class UnionFindSet{
        //Key指的是node本身（Child），Value指的是该node的父节点(father)
        public HashMap<Node,Node> fatherMap;
        //某一个节点（Key）所在的集合一共有多少个节点(Value)
        public HashMap<Node, Integer> sizeMap;

        public UnionFindSet(List<Node> nodes){
            makeSets(nodes);
        }

        //初始化操作
        private void makeSets(List<Node> nodes){
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            //每一个节点自己形成一个集合
            nodes.forEach(n -> {
                fatherMap.put(n,n);
                sizeMap.put(n,1);
            });
        }

        private Node findHead(Node node){
            Node father = fatherMap.get(node);
            if (father != node){
                father = findHead(father);
            }
            //优化操作，将每一次遍历查找到的节点放置在跟节点之下
            fatherMap.put(node,father);
            return father;
        }

        private Node findHeadUnRecur(Node node){
            Node father = fatherMap.get(node);
            Node head = node;
            while(father != node){
                node = father;
                father = fatherMap.get(node);
            }
            while (head != father){
                fatherMap.put(node,father);
                head = fatherMap.get(head);
            }
            return father;
        }

        private boolean isTheSameSet(Node nodeA, Node nodeB){
            return findHead(nodeA) == findHead(nodeB);
        }

        private void union(Node a, Node b){
            if(a == null || b == null){
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead) {
                int aSize = sizeMap.get(aHead);
                int bSize = sizeMap.get(bHead);
                if(aSize < bSize){
                    fatherMap.put(aHead,bHead);
                    sizeMap.put(bHead, aSize + bSize);
                }else {
                    fatherMap.put(bHead,aHead);
                    sizeMap.put(aHead,aSize + bSize);
                }
            }
        }
    }

    public static void main(String[] args) {

    }
}
