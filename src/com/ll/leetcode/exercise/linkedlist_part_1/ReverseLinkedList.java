package com.ll.leetcode.exercise.linkedlist_part_1;

//已知链表头结点指针head，将链表逆序，不申请额外空间
//LeetCode206.Reverse LinkedList   --->It's easy

public class ReverseLinkedList {
    public ListNode first;
    public int size;

    public ReverseLinkedList(){
        first = null;
        size = 0;
    }

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

    public static ListNode reverseListNode(ListNode first){
        ListNode f = null;
        ListNode cur = first;
        while(cur != null){
            ListNode n = null;
            n = cur;
            cur = cur.next;
            n.next = f;
            f = n;
        }
        return f;
    }

    public static ListNode reverseListNode2(ListNode first){
        ListNode head = first;
        ListNode new_head = null;
        while(head != null){
            ListNode headNext = head.next;  //1、备份head.next
            head.next = new_head;       //2、更新head.next
            new_head = head;            //3、移动new_head
            head = headNext;            //4、遍历链表
        }
        return new_head;
    }
    public static ListNode reverseBetween(ListNode head,int m,int n){
        int change_len = n - m + 1;     //计算需要逆置的节点个数
        ListNode pre_head = null;       //初始化开始逆置的节点的前驱
        ListNode result = head;         //最终转换后的链表头结点，非特殊情况即为head
        while(head.next != null && --m != 0){     //将head向前移动m-1个位置
            pre_head = head;    //记录head的前驱
            head = head.next;
        }
        //逆置change_len个结点
        ListNode modify_list_tail = head;
        ListNode new_head = null;
        while(head !=null && change_len != 0){
            ListNode next = head.next;
            head.next = new_head;
            new_head = head;
            head = next;
            change_len--;       //每完成一个结点逆置，change_leng--
        }

        modify_list_tail.next = head;
        if(pre_head!=null){
            pre_head.next=new_head;
        }else{
            result=new_head;
        }
        return result;
    }

    public static void printLinkedList(ListNode first){
        ListNode cur = first;
        if(cur == null){
            System.out.println("It's an empty list!");
            return;
        }
        while(cur != null) {
            System.out.print(cur.val);
            if (cur.next != null) {
                System.out.print(" -> ");
            }
            cur = cur.next;
        }
    }

    public static void main(String[] args){
        ReverseLinkedList rll = new ReverseLinkedList();
        rll.add(new ListNode(1));
        rll.add(new ListNode(2));
        rll.add(new ListNode(3));
        rll.add(new ListNode(4));
        rll.add(new ListNode(5));
        printLinkedList(rll.first);
        System.out.println();
        rll.first = reverseListNode(rll.first);
        System.out.println();
        printLinkedList(rll.first);
        System.out.println();
        rll.first = reverseListNode(rll.first);
        printLinkedList(rll.first);
        System.out.println();
        rll.first = reverseListNode(rll.first);
        printLinkedList(rll.first);
        System.out.println();
        rll.first = reverseListNode2(rll.first);
        printLinkedList(rll.first);
        System.out.println();
        rll.first = reverseBetween(rll.first,2,4);
        printLinkedList(rll.first);
    }
}
