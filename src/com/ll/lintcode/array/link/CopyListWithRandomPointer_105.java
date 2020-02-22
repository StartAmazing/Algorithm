package com.ll.lintcode.array.link;

import com.ll.lintcode.utils.RandomListNode;

import java.util.HashMap;

/**
 * 给出一个链表，每个节点包含一个额外增加的随机指针可以
 * 指向链表中的任何节点或者空的节点
 *
 * 返回一个链表的深度拷贝
 */
public class CopyListWithRandomPointer_105 {

    //version 1: use a hashMap, O(n) extra space
    public RandomListNode copyRandomList1(RandomListNode head){
        if (head == null){
            return null;
        }

        //map映射的是旧节点到新节点的映射关系
        HashMap<RandomListNode, RandomListNode> old2newMap = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode pre = dummy, newNode;
        while (head != null){
            if (old2newMap.containsKey(head)){
                newNode = old2newMap.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                old2newMap.put(head, newNode);
            }
            pre.next = newNode;

            if(head.random != null){
                //two conditions, in or not in node2RandomMap
                if(old2newMap.containsKey(head.random)){
                    newNode.random = old2newMap.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    old2newMap.put(head.random, newNode.random);
                }
            }

            pre = newNode;
            head = head.next;
        }

        return dummy.next;
    }

    //======================================================================================
    //version2: no hashMap version
    //第一遍扫描的时候巧妙选用next指针,开始数据是1 -> 2 -> 3 -> 4 -> null
    //然后扫描过程中，先建立copy节点 1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4' -> null
    public RandomListNode copyRandomList2(RandomListNode head){
        if (head == null){
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return splitList(head);
    }

    //1 -> 2 -> 3 -> 4 -> null
    //1 -> 1' -> 2 -> 2' -> 3 -> 3' -> 4 -> 4' -> null
    //这一步做完n'的random指针指向是不正确的
    //step1 copy all nodes
    private void copyNext(RandomListNode head){
        while (head != null){
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    //step2 copy all nodes' random point
    private void copyRandom(RandomListNode head){
        while (head != null){
            if (head.next.random != null){
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    //step3 split the big linked list
    private RandomListNode splitList(RandomListNode head){
        RandomListNode newHead = head.next;
        while (head != null){
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if(temp.next != null){
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }

}
