package com.ll.leetcode.exercise.linkedlist_part_1;

import java.util.Comparator;
import java.util.Vector;

//已知k个已排序的链表头结点指针，将这k个链表合并，合并后仍然为有序的，
//LeetCode 23 Merage k Sorted Lists     Hard
public class MergeKSortedLists {
    public int val;
    public MergeKSortedLists next;
    public MergeKSortedLists(int val){
        this.val = val;
        this.next = null;
    }

    //vec存储各个List的头结点指针
    //方案一：根据两个链表的合并，k个链表的按照顺序合并k-1次
    //设有k个链表，平均每个链表有n个结点，时间复杂度为O(k^2*n)-----太高了
    //方案二：将k*n个结点放到vector，中，再将结点顺序相连
    //设有k个链表，平均每个链表有n个结点，时间复杂度为O(kN*logkN)
    //方案三：对k个链表进行分治，两两进行合并
    //设有k个链表，平均每个链表有n个结点，时间复杂度O(kNlog k)
    public static MergeKSortedLists mergeKLists(Vector<MergeKSortedLists> lists){

        Vector<MergeKSortedLists> node_vec = new Vector<>();
        for(int i = 0; i< lists.size();i++){
            MergeKSortedLists head = lists.get(i);
            while(head != null){
                node_vec.add(head);
                head = head.next;
            }
        }
        if(node_vec.size() == 0){
            return null;
        }
        node_vec.sort(new Comparator<MergeKSortedLists>() {
            @Override
            public int compare(MergeKSortedLists o1, MergeKSortedLists o2) {
                return o1.val - o2.val;
            }
        });
        for(int i = 0; i < node_vec.size() - 1; i++){
            node_vec.get(i).next = node_vec.get(i+1);
        }
        node_vec.get(node_vec.size() - 1).next = null;
        return node_vec.get(0);
    }

    public static MergeKSortedLists mergeTwoLists(MergeKSortedLists l1, MergeKSortedLists l2){
        MergeKSortedLists new_head = new MergeKSortedLists(Integer.MAX_VALUE);   //设置临时头结点
        MergeKSortedLists cur = new_head;  //设置移动指针用来添加结点
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

    public static MergeKSortedLists mergeKLists3(Vector<MergeKSortedLists> lists){
        if(lists.size() == 0){
            return null;
        }
        if(lists.size() == 1){
            return lists.get(0);
        }
        if(lists.size() == 2){
            return mergeTwoLists(lists.get(0),lists.get(1));
        }
        int mid = lists.size() / 2;
        Vector<MergeKSortedLists> sub1_lists = new Vector<>();
        Vector<MergeKSortedLists> sub2_lists = new Vector<>();

        for(int i = 0; i< mid;i++){
            sub1_lists.add(lists.get(i));
        }
        for(int i = mid; i< lists.size();i++){
            sub2_lists.add(lists.get(i));
        }

        MergeKSortedLists l1 = mergeKLists3(sub1_lists);
        MergeKSortedLists l2 = mergeKLists3(sub2_lists);

        return mergeTwoLists(l1,l2);
    }

    public static void printMergeList(MergeKSortedLists k){
        while (k != null){
            System.out.print(k.val);
            if(k.next != null){
                System.out.print("-next->");
            }else{
                System.out.println();
            }
            k = k.next;
        }
    }

    public static void main(String[] args) {
        MergeKSortedLists a = new MergeKSortedLists(1);
        MergeKSortedLists b = new MergeKSortedLists(2);
        MergeKSortedLists c = new MergeKSortedLists(3);
        MergeKSortedLists d = new MergeKSortedLists(4);
        MergeKSortedLists e = new MergeKSortedLists(5);
        MergeKSortedLists f = new MergeKSortedLists(6);
        MergeKSortedLists g = new MergeKSortedLists(7);
        MergeKSortedLists h = new MergeKSortedLists(8);
        MergeKSortedLists i = new MergeKSortedLists(9);
        MergeKSortedLists j = new MergeKSortedLists(10);
        MergeKSortedLists k = new MergeKSortedLists(11);
        MergeKSortedLists l = new MergeKSortedLists(12);
        MergeKSortedLists m = new MergeKSortedLists(13);

        a.next = b;
        b.next = m;

        c.next = e;
        e.next = g;

        d.next = j;
        j.next = k;

        f.next = h;
        h.next = i;
        i.next = l;

        System.out.print("l1: ");
        printMergeList(a);
        System.out.print("l2: ");
        printMergeList(c);
        System.out.print("l3: ");
        printMergeList(d);
        System.out.print("l4: ");
        printMergeList(f);



        Vector<MergeKSortedLists> vector = new Vector<>();
        vector.add(a);
        vector.add(c);
        vector.add(d);
        vector.add(f);
        System.out.println("=========after merge2===========");
//        MergeKSortedLists mergeKSortedLists = mergeKLists(vector);
//        printMergeList(mergeKSortedLists);
        System.out.println("=========after merge3===========");
        MergeKSortedLists mergeKSortedLists1 = mergeKLists3(vector);
        printMergeList(mergeKSortedLists1);
    }
}

