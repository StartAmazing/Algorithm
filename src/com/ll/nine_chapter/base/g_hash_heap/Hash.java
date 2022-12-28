package com.ll.nine_chapter.base.g_hash_heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hash {

    /**
     * @link https://www.lintcode.com/problem/134/
     */
    static class LRUCache {

        private Map<Integer, DoublyListNode> map;
        private int capacity;
        private int size;
        private DoublyListNode head;
        private DoublyListNode tail;

        /*
         * @param capacity: An integer
         */
        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            this.map = new HashMap<>();
            this.head = new DoublyListNode(-1, -1);
            this.tail = new DoublyListNode(-1, -1);
            this.head.next = this.tail;
            this.tail.pre = this.head;
        }

        /*
         * @param key: An integer
         * @return: An integer
         */
        public int get(int key) {
            DoublyListNode resNode;
            if((resNode = findNode(key)) == null) {
                return -1;
            }

            return resNode.val;
        }

        /*
         * @param key: An integer
         * @param value: An integer
         * @return: nothing
         */
        public void set(int key, int value) {
            DoublyListNode resNode;
            if ((resNode = findNode(key)) != null) {
                resNode.val = value;
                moveToTail(resNode);
            } else {
                if(size == capacity) { // full
                    size--;
                    this.map.remove(this.head.next.key);
                    this.head.next.next.pre = this.head;
                    this.head.next = this.head.next.next;
                }

                size++;
                DoublyListNode newNode = new DoublyListNode(key, value, this.tail, this.tail.pre);
                this.tail.pre.next = newNode;
                this.tail.pre = newNode;

                this.map.put(key, newNode);
            }
        }

        private DoublyListNode findNode(int key) {
            if(!this.map.containsKey(key)) {
                return null;
            }

            DoublyListNode curNode = this.map.get(key);
            moveToTail(curNode);

            return curNode;
        }

        private void moveToTail(DoublyListNode node) {
            node.pre.next = node.next;
            node.next.pre = node.pre;

            node.pre = this.tail.pre;
            this.tail.pre.next = node;
            node.next = this.tail;
            this.tail.pre = node;
        }
    }

    static class DoublyListNode {
        public DoublyListNode next;
        public DoublyListNode pre;
        public Integer val;
        public Integer key;

        public DoublyListNode(int key, int val) {
             this.key = key;
             this.val = val;
        }

        public DoublyListNode(int key, int val, DoublyListNode next, DoublyListNode pre) {
            this.key = key;
            this.val = val;
            this.pre = pre;
            this.next = next;
        }
    }

    public static void main(String[] args) {
    }

}
