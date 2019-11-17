package com.ll.zs.advance.mytest;

import java.util.HashMap;

/**
 * 设计可以变更的缓存结构          LRU
 * 设计一种缓存结构，该结构在构造时确定大小，假设大小为k,并且有两个功能
 * set(key, value):将记录(key, value)插入该结构
 * get(key):返回key对应的value的值
 *
 * 要求：
 * 1. set和get方法的时间复杂度为O(1)
 * 2. 某个key的set或者get操作 一旦发生 ，认为这个key的记录成了最经常使用的
 * 3. 当缓存的大小超过K时，移除最不经常使用的记录，即set或get最久远的
 *
 *
 * 举例：
 * 假设缓存结构的实例是cache,大小为3，并依次发生如下的行为
 * 1. cache.set("A",1)。最经常使用的记录为("A",1)
 * 2. cache.set("B",2)。最经常使用的记录为（"B",2）,("A",1)变为最不经常使用的
 * 3. cache.set("C",3)。最经常使用的记录为（"C",2）,("A",1)还是最不经常使用的
 * 4. cache.set("A")。最经常使用的记录为("C",2),("B",2)变为最不经常使用的
 * 5. cache.set("D",4)。大小超过了3，所以移除此时最不经常使用的记录("B",2)
 * 加入记录("D",4)，并且为最经常使用的记录，然后("C",2)变为最不经常使用的记录
 */
public class MyCache_LRU {

    public static class Node<T>{
        public T value;
        public Node<T> last;        //前指针
        public Node<T> next;        //后指针

        public Node(T value){
            this.value = value;
        }
    }

    public static class NodeDoubleLinkedList<V>{
        private Node<V> head;
        private Node<V> tail;

        public NodeDoubleLinkedList(){
            this.head = null;
            this.tail = null;
        }

        public void addNode(Node<V> newNode){
            if(newNode == null){
                return;
            }
            if(this.head == null){
                this.head = newNode;
                this.tail = newNode;
            }else{
                //从尾部进，从头部出
                this.tail.next = newNode;
                newNode.next = this.tail;
                this.tail = newNode;
            }
        }

        private void moveNodeToTail(Node target){
            if(this.tail == target){
                return;
            }
            if(this.head == target){
                this.head = target.next;
                this.head = null;
            }else{
                target.next.last = target.last;
                target.last.next = target.next;
            }
            target.last = this.tail;
            target.next = null;
            this.tail.next = target;
            this.tail = target;
        }

        private Node<V> removeHead(){
            if(this.head == null){
                return null;
            }
            Node<V> cur = this.head;
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = cur.next;
                this.head.last = null;
                cur.next = null;
            }
            return cur;
        }
    }

    public static class MyCache<K,V>{
        private HashMap<K, Node<V>> keyNodeMap;
        private HashMap<Node<V>, K> nodeKeyMap;
        private NodeDoubleLinkedList<V> nodeList;
        private int capacity;

        public MyCache(int capacity){
            if(capacity < 1){
                throw new RuntimeException("capacity should be more than one!");
            }
            this.keyNodeMap = new HashMap<>();
            this.nodeKeyMap = new HashMap<>();
            this.nodeList = new NodeDoubleLinkedList<>();
            this.capacity = capacity;
        }

        public V get(K key){
            if(this.keyNodeMap.containsKey(key)){
                Node<V> node = this.keyNodeMap.get(key);
                this.nodeList.moveNodeToTail(node);
                return node.value;
            }
            return null;
        }

        public void set(K key, V val){
            if (this.keyNodeMap.containsKey(key)){
                Node<V> node = this.keyNodeMap.get(key);
                node.value = val;
                this.nodeList.moveNodeToTail(node);
            }else{
                Node<V> newNode = new Node<>(val);
                this.keyNodeMap.put(key,newNode);
                this.nodeKeyMap.put(newNode,key);
                this.nodeList.addNode(newNode);
                if(this.keyNodeMap.size() == this.capacity + 1){
                    removeMostUnsedCache();
                }
            }
        }

        private void removeMostUnsedCache(){
            Node<V> node = this.nodeList.removeHead();
            K k = nodeKeyMap.get(node);
            nodeKeyMap.remove(node);
            keyNodeMap.remove(k);
        }
    }


}
