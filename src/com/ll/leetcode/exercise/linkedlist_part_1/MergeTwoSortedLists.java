package com.ll.leetcode.exercise.linkedlist_part_1;

//已知两个已排序的链表头结点指针l1和l2，将这两个链表合并，合并后仍为有序的，返回合并后的头结点
//leetCode 21 Merge Two Sorted Lists        Easy
public class MergeTwoSortedLists {
    public int val;
    public MergeTwoSortedLists next;
    public MergeTwoSortedLists(int val){
        this.val = val;
        this.next = null;
    }

    public static MergeTwoSortedLists mergeTwoLists(MergeTwoSortedLists l1, MergeTwoSortedLists l2){
       MergeTwoSortedLists new_head = new MergeTwoSortedLists(Integer.MAX_VALUE);   //设置临时头结点
       MergeTwoSortedLists cur = new_head;  //设置移动指针用来添加结点
       while(l1 != null && l2 != null){     //l1与l2同时不空时，对他们进行比较
           if(l1.val > l2.val){
               cur.next = l2;
               l2 = l2.next;
           }else{
               cur.next = l1;
               l1 = l1.next;
           }
           cur = cur.next;
       }
       while(l1 != null){
           cur.next = l1;
           l1 = l1.next;
           cur = cur.next;
       }
       while(l2 != null){
           cur.next = l2;
           l2 = l2.next;
           cur = cur.next;
       }
       return new_head.next;
    }

    public static void printList(MergeTwoSortedLists head){
        while(head != null){
            System.out.print(head.val);
            if(head.next != null){
                System.out.print( "-next->" );
            }else{
                System.out.println();
            }
            head = head.next;
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedLists a = new MergeTwoSortedLists(1);
        MergeTwoSortedLists b = new MergeTwoSortedLists(14);
        MergeTwoSortedLists c = new MergeTwoSortedLists(15);
        MergeTwoSortedLists d = new MergeTwoSortedLists(18);
        MergeTwoSortedLists e = new MergeTwoSortedLists(21);
        MergeTwoSortedLists f = new MergeTwoSortedLists(42);
        MergeTwoSortedLists g = new MergeTwoSortedLists(67);
        MergeTwoSortedLists h = new MergeTwoSortedLists(77);
        MergeTwoSortedLists i = new MergeTwoSortedLists(82);
        MergeTwoSortedLists j = new MergeTwoSortedLists(90);
        MergeTwoSortedLists k = new MergeTwoSortedLists(101);
        MergeTwoSortedLists l = new MergeTwoSortedLists(123);
        MergeTwoSortedLists m = new MergeTwoSortedLists(132);

        a.next = b;
        b.next = f;
        f.next = g;
        g.next = m;

        c.next = d;
        d.next = e;
        e.next = h;
        h.next = i;
        i.next = j;
        j.next = k;
        k.next = l;

        printList(a);
        printList(c);
        System.out.println("============================");

        MergeTwoSortedLists list = mergeTwoLists(a, c);
        printList(list);


    }


}
