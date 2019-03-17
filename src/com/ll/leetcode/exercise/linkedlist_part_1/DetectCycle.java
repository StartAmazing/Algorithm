package com.ll.leetcode.exercise.linkedlist_part_1;

import java.util.HashSet;

//已知链表中可能存在环，若有环返回环的起始点，否则返回null
//leetcode   142   medium
public class DetectCycle {
    public ListNode first;
    public int size;
    public static class ListNode{
        int val;    //数据域
        ListNode next;     //指针域
        public ListNode(int v){
            this.val = v;
            this.next = null;
        }

    }
    public void add(ListNode node){
        if (this.first == null){
            this.first = node;
            size++;
            return;
        }
        ListNode cur = first;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = node;
        size++;
    }
    /* 方案1:
     * 1、遍历链表，将链表中结点对应的结点放入一个set集合中
     * 2、在遍历时插入节点前，需要在set中查找，第一个在set中发现的结点地址，即是链表环的起点
     */
    public static ListNode getStartCycleNode(ListNode head){
        HashSet<ListNode> sets = new HashSet<>();
        ListNode curNode = head;
        while(curNode != null){
            if(!sets.contains(curNode)) {
                sets.add(curNode);
                curNode = curNode.next;
            }else{
                return curNode;
            }
        }
        return null;
    }

    /* 方案2：
     * 快慢指针思想
     * 首先先证明此是否有环链表，如果没有链表则返回null
     * 如果有链表，即快慢指针在环中相遇，
     * 那么将快指针返回其实head,速度=慢指针速度，那么再次相遇的结点
     * 即为环的起始点
     * @param head
     * @return
     */
    public static ListNode getStartCycleNode2(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        ListNode meet = null;
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
            if(fast == null){
                return null;    //保证不会空指针异常
            }
            fast = fast.next;       //fast再走一步
            if(fast == slow){        //fast与slow相遇
                meet = fast;
                break;
            }
        }
        if(meet == null){
            return null;    //如果没有相遇那么证明没有环
        }
        while(head!= null && meet !=null){
            if(head == meet){   //当head与meet相遇，说明遇到环的起始位置
                return head;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;
    }

    public static void main(String[] args) {
        DetectCycle A = new DetectCycle();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);
        ListNode i = new ListNode(9);
        A.add(a);
        A.add(b);
        A.add(c);
        A.add(d);
        A.add(e);
        A.add(f);
        A.add(g);
        A.add(h);
        A.add(i);
        A.add(c);

        ListNode start = getStartCycleNode(A.first);
        if(start != null){
            System.out.println(start.val);
        }else{
            System.out.println(start);
        }

        start = getStartCycleNode2(A.first);
        if(start != null){
            System.out.println(start.val);
        }else{
            System.out.println(start);
        }

    }
}
