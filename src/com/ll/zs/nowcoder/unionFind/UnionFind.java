package com.ll.zs.nowcoder.unionFind;

import java.util.HashMap;
import java.util.List;

public class UnionFind {
    public static class Node{
        //whatever you like. String, Int, Char..
    }

    public static class UnionFindSet{
        public HashMap<Node, Node> fatherMap;// Key : Child , value : father
        public HashMap<Node, Integer> sizeMap;

        //只接受一次性把所有样本加入并查集中
        public UnionFindSet(List<Node> nodes){
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes){
            fatherMap = new HashMap<Node, Node>();
            sizeMap = new HashMap<Node, Integer>();
            for(Node node : nodes){
                fatherMap.put(node, node);  //每一个node自己形成一个集合
                sizeMap.put(node, 1);
            }
        }

        //找到当前结点的父节点并且将所有子节点的父节点均指向最高层的父节点
        private Node findHead(Node node) {
            //非递归写法
//            Stack<Node> stack = new Stack<Node>();
//            Node cur = node;
//            Node parent = fatherMap.get(node);
//            while(node != parent){
//                stack.push(parent);
//                node = parent;
//                parent = fatherMap.get(node);
//            }
//            while(!stack.isEmpty()){
//                fatherMap.put(stack.pop(), parent);
//            }
//            return parent;



            Node father = fatherMap.get(node);
            if (father != node)
                father = findHead(father);
            fatherMap.put(node,father); //变扁平，压缩
            return father;
        }

        //a的代表结点和b的代表结点是否一致
        public boolean isSameSet(Node a, Node b){
            return findHead(a) == findHead(b);
        }

        //合并两个并查集
        public void union(Node a, Node b){
            if(a == null || b == null)
                return;
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if(aHead != bHead){
                int aSetSize = sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if(aSetSize <= bSetSize){
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                }else{
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}
