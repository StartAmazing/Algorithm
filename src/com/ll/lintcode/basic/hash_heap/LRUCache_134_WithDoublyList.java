package com.ll.lintcode.basic.hash_heap;

import java.util.HashMap;
import java.util.Map;

/**
 * 为最近最少使用（LRU）缓存策略设计一个数据结构，它应该支持以下操作：获取数据和写入数据。
 *
 * get(key) 获取数据：如果缓存中存在key，则获取其数据值（通常是正数），否则返回-1。
 * set(key, value) 写入数据：如果key还没有在缓存中，则写入其数据值。当缓存达到上限，它应该在写入新数据之前删除最近最少使用的数据用来腾出空闲位置。
 * 最终, 你需要返回每次 get 的数据.
 *
 * 样例
 * 样例 1:
 *
 * 输入：
 * LRUCache(2)
 * set(2, 1)
 * set(1, 1)
 * get(2)
 * set(4, 1)
 * get(1)
 * get(2)
 * 输出：[1,-1,1]
 * 解释：
 * cache上限为2，set(2,1)，set(1, 1)，get(2) 然后返回 1，set(4,1) 然后 delete (1,1)，因为 （1,1）最少使用，get(1) 然后返回 -1，get(2) 然后返回 1。
 * 样例 2:
 *
 * 输入：
 * LRUCache(1)
 * set(2, 1)
 * get(2)
 * set(3, 2)
 * get(2)
 * get(3)
 * 输出：[1,-1,2]
 * 解释：
 * cache上限为 1，set(2,1)，get(2) 然后返回 1，set(3,2) 然后 delete (2,1)，get(2) 然后返回 -1，get(3) 然后返回 2。
 */
public class LRUCache_134_WithDoublyList {

    private class Node{
        Node prev;
        Node next;
        int key;
        int value;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private Map<Integer, Node> hs = new HashMap<>();
    private Node head = new Node(-1,1);
    private Node tail = new Node(-1,1);

    public LRUCache_134_WithDoublyList(int capacity){
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }

    public int getKey(int key){
        if (!hs.containsKey(key)){
            return -1;
        }

        //remove current
        Node current = hs.get(key);
        current.prev.next = current.next;
        current.next.prev = current.prev;

        //move current to tail
        moveToTail(current);

        return hs.get(key).value;
    }

    public void set(int key, int value){
        if (getKey(key) != -1){
            hs.get(key).value = value;
            return;
        }

        if (hs.size() == capacity){
            hs.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }

        Node insert = new Node(key,value);
        hs.put(key, insert);
        moveToTail(insert);
    }


    private void moveToTail(Node cur){
        tail.prev.next = cur;
        cur.next = tail;
        cur.prev = tail.prev;
        tail.prev = cur;
    }

    public static void main(String[] args) {
        LRUCache_134_WithDoublyList dto = new LRUCache_134_WithDoublyList(2);
        dto.set(2,1);
        dto.set(1,1);
        int x = dto.getKey(2);
        System.out.println(x);
        dto.set(4,1);
        x = dto.getKey(1);
        System.out.println(x);
        x = dto.getKey(2);
        System.out.println(x);
    }
}
