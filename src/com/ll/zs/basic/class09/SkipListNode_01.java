package com.ll.zs.basic.class09;

import java.util.ArrayList;
import java.util.Iterator;

public class SkipListNode_01 {

    public static class SkipListNode{
        public Integer value;
        public ArrayList<SkipListNode> nextsNodes;

        public SkipListNode(Integer value){
            this.value = value;
            nextsNodes = new ArrayList<>();
        }
    }

    public static class SkipListIterator implements Iterator<Integer>{
        SkipList list;
        SkipListNode current;

        public SkipListIterator(SkipList list){
            this.list = list;
            this.current = list.getHead();
        }

        @Override
        public boolean hasNext() {
            return current.nextsNodes.get(0) != null;
        }

        @Override
        public Integer next(){
            current = current.nextsNodes.get(0);
            return current.value;
        }

    }

    public static class SkipList{
        private SkipListNode head;
        private int maxLevel;
        private int size;
        private static final double PROBABILITY = 0.5;

        public SkipList(){
            size = 0;
            maxLevel = 0;
            head = new SkipListNode(null);
            head.nextsNodes.add(null);
        }

        public SkipListNode getHead(){
            return head;
        }

        public void add(Integer newValue){
            if(!contains(newValue)){
                size ++;
                int level = 0;
                while (Math.random() < PROBABILITY){
                    level ++;
                }
                while (level > maxLevel){
                    head.nextsNodes.add(null);
                    maxLevel++;
                }
                SkipListNode newNode = new SkipListNode(newValue);
                SkipListNode current = head;
                do{
                    current = findNext(newValue,current,level);
                    newNode.nextsNodes.add(0,current.nextsNodes.get(level));
                    current.nextsNodes.set(level,newNode);
                }while (level -- > 0);
            }
        }

        private boolean contains(Integer value){
            SkipListNode node = find(value);
            return node != null && node.value != null && equalTo(node.value,value);
        }

        private SkipListNode find(Integer e){
            return find(e,head,maxLevel);
        }

        private SkipListNode find(Integer e, SkipListNode current,int level){
            do{
                current = findNext(3,current,level);
            }while (level-- > 0);
            return current;
        }

        private SkipListNode findNext(Integer e, SkipListNode current, int level){
            SkipListNode next = current.nextsNodes.get(level);
            while (next != null){
                Integer value = next.value;
                if(lessThan(e,value)){      //e < value
                    break;
                }
                current = next;
                next = current.nextsNodes.get(level);
            }
            return current;
        }
        public int size(){
            return size;
        }

        private boolean lessThan(int e, int v) {
            return e < v ;
        }

        private boolean equalTo(int m,int n){
            return m == n;
        }

    }

}
