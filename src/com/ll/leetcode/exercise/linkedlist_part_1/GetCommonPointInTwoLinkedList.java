package com.ll.leetcode.exercise.linkedlist_part_1;


import java.util.HashSet;
import java.util.Set;

//已知链表A的头结点指针headA，链表B的头结点指针headB,两链表相交，求两链表交点对应的结点
//LeetCode 160   easy
//要求：
/*
*  1、如果两个链表没有交点，则返回null
*  2、在求交点的过程中，不可以破坏链表的结构或者修改链表的数据域
*  3、可以确保传入的链表A与链表B没有环
*  4、实现算法尽可能使时间复杂度O（n）,空间复杂度为O(1)
*
*/
public class GetCommonPointInTwoLinkedList {
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

    public static ListNode getInterSectionNode(ListNode headA,ListNode headB){
        //先声明一个Set集合用来存储链表结点
        HashSet<ListNode> listSet = new HashSet<>();
        ListNode curNode = headA;

        while(curNode != null){
            listSet.add(curNode);
            curNode = curNode.next;
        }
        curNode = headB;
        while(curNode != null && !listSet.contains(curNode) ){
            curNode = curNode.next;
            if(curNode == null){
                return null;
            }
        }
        return curNode;
    }

    public static ListNode getInterSectionNode2(ListNode headA,ListNode headB){
        int list_A_len = getListLength(headA);
        int list_B_len = getListLength(headB);
        if(list_A_len > list_B_len){
            headA = forward_log_list(list_A_len,list_B_len,headA);
        }else{
            headB = forward_log_list(list_B_len,list_A_len,headB);
        }
        while(headA != null && headB != null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    /**
     * 求链表长度函数
     * @param head
     */
    private static int getListLength(ListNode head){
        int len = 0;
        while(head != null){
            head = head.next;
            len++;
        }
        return len;
    }

    /**
     * 将指针向前移动至多出结点个数后面的位置
     */
    private static ListNode forward_log_list(int long_len, int short_len,ListNode head){
        int delta = long_len -  short_len;
        while(head != null && delta != 0){
            head = head.next;
            delta --;
        }
        return head;
    }





    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        ListNode h = new ListNode(8);

        ListNode A = new ListNode(10);
        ListNode B = new ListNode(11);

        A.next = a;
        a.next = b;
        b.next = d;
        d.next = e;

        B.next = c;
        c.next = f;
        f.next = g;
        g.next = e;
        e.next = h;

        ListNode res = getInterSectionNode(A,B);
        res = getInterSectionNode2(A,B);
        if(res == null){
            System.out.println(res);
        }else {
            System.out.println(res.val);
        }
    }

}
