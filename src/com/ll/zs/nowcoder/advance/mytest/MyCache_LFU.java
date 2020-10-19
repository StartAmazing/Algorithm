package com.ll.zs.nowcoder.advance.mytest;

import java.util.HashMap;

public class MyCache_LFU {

    public static class Node{
        public Integer key;     //k
        public Integer value;   //v
        public Integer times;   //出现的次数
        public Node up;     //双指针
        public Node down;   //双指针

        public Node(int key, int value, int times){
            this.key = key;
            this.value = value;
            this.times = times;
        }
    }

    public static class LFUCache{
        public static class NodeList{

            public Node head;
            public Node tail;
            public NodeList last;       //上一个
            public NodeList next;       //下一个

            public NodeList(Node node){
                head = node;
                tail = node;
            }

            public void addNodeFromHead(Node newHead){
                newHead.down = head;
                head.up = newHead;
                head = newHead;
            }

            public boolean isEmpty(){
                return head == null;
            }

            public void deleteNode(Node node){
                if(head == tail){
                    head = null;
                    tail = null;
                }else{
                    if(node == head){
                        head = node.down;
                        head.up = null;
                    }else if(node == tail){
                        tail = node.up;
                        tail.down = null;
                    }else{
                        node.up.down = node.down;
                        node.down.up = node.up;
                    }
                }
                node.up = null;
                node.down = null;
            }
        }

        private int capacity;   //容量
        private int size;       //实际存放元素个数
        private HashMap<Integer, Node> records; //key(Integer)，可以改变成其他类型 -> node
        private HashMap<Node,NodeList> heads;       //根据Node找到与他对应的NodeList
        private NodeList headList;     //整个大结构第一个NodeList

        public LFUCache(int capacity){
            this.capacity = capacity;
            this.size = 0;
            this.records = new HashMap<>();
            this.heads = new HashMap<>();
            headList = null;
        }

        public void set(int key, int value){
            if(records.containsKey(key)){
                Node node = records.get(key);
                node.value = value;
                node.times ++;
                NodeList curNodeList = heads.get(node);
                move(node, curNodeList);        //先从大连表中拿出来，移动node到下一个nodeList中去
            }else{
                if(size == capacity){           //size到达阈值
                    Node node = headList.tail;
                    headList.deleteNode(node);
                    modifyHeadList(headList);   //如果node中没有了，那么删除NodeList,可能牵扯到换头的问题
                    records.remove(node.key);
                    heads.remove(node);
                    size --;
                }
                Node node = new Node(key, value, 1);
                if(headList == null){
                    headList = new NodeList(node);
                }else {
                    if(headList.head.times.equals(node.times)){
                        headList.addNodeFromHead(node);
                    }else{
                        NodeList newList = new NodeList(node);
                        newList.next = headList;
                        headList.last = newList;
                        headList = newList;
                    }
                }
                records.put(key,node);
                heads.put(node,headList);
                size++;
            }
        }

        private void move(Node node, NodeList oldNodeList){
            oldNodeList.deleteNode(node);
            NodeList preList = modifyHeadList(oldNodeList) ? oldNodeList.last : oldNodeList;
            NodeList nextList = oldNodeList.next;
            if(nextList == null){
                NodeList newList = new NodeList(node);
                if(preList != null){
                    preList.next = newList;
                }
                newList.last = preList;
                if (headList == null){
                    headList = newList;
                }
                heads.put(node,newList);
            }else{
                if(nextList.head.times.equals(node.times)){
                    nextList.addNodeFromHead(node);
                    heads.put(node,nextList);
                }else{
                    NodeList newList = new NodeList(node);
                    if(preList != null){
                        preList.next = newList;
                    }
                    newList.last = preList;
                    newList.next = nextList;
                    nextList.last = newList;
                    if(headList == nextList){
                        headList = newList;
                    }
                    heads.put(node,newList);
                }
            }
        }

        //return wheather delete this head
        private boolean modifyHeadList(NodeList nodeList){
            if(nodeList.isEmpty()){
                if(headList == nodeList){
                    headList = nodeList.next;
                    if(headList != null){
                        headList.last = null;
                    }
                }else{
                    nodeList.last.next = nodeList.next;
                    if(nodeList.next != null){
                        nodeList.next.last = nodeList.last;
                    }
                }
                return true;
            }
            return false;
        }

        public int get(int key){
            if(!records.containsKey(key)){
                return -1;
            }
            Node node = records.get(key);
            node.times ++;
            NodeList curNodeList = heads.get(node);
            move(node,curNodeList);
            return node.value;
        }

    }

}
