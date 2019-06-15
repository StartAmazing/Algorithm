package com.ll.leetcode.exercise.linkedlist_part_1;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

//已知一个复杂的链表，节点中有一个指向本链表任意某个结点的随机指针（也可以为空）
//求这个链表的深度拷贝；深度拷贝：构造生成一个完全新的链表，即使将原链表破坏，新链表依旧可以独立使用
//leetcode  138 hard    Copy List With Random Pointer
public class RandomListNode {
    private int label;
    private RandomListNode next,random;     //带有随机指针的链表结点
    public RandomListNode(int x){
        this.label = x;
        this.next = null;
        this.random = null;
    }

    public static RandomListNode copyRandomList(RandomListNode head){      //返回时深度拷贝后的链表
        HashMap<Integer, RandomListNode> node_map = new HashMap<Integer,RandomListNode>(); //地址到结点位置的map
        Vector<RandomListNode> node_vec = new Vector<>();   //使用vector根据存储结点位置访问地址
        RandomListNode cur = head;
        int i = 0;
        while(cur != null){
            node_vec.add(new RandomListNode(cur.label));
            node_map.put(i,cur.random);         //记录原始链表地址至结点位置的node_map
            cur = cur.next; //遍历原始列表
            i++;    //记录结点位置
        }
//          node_vec.add(new RandomListNode(0));
        cur = head;
        i = 0;  //再次遍历原始列表 连接新链表的next指针，random指针
        while(cur.next != null){
            node_vec.get(i).next = node_vec.get(i+1);
            if(cur.random != null){     //当random指针不为空时
                RandomListNode rln = node_map.get(i);  //根据node_map确认
                node_vec.get(i).random = rln;      //原链表random指针指向的位置即id
            }   //重新连接新链表的random指针
            cur = cur.next;
            i++;
        }
        return node_vec.get(0);
    }

    public static void printRandomList(RandomListNode head){
        RandomListNode cur = head;
        while(cur != null){
            System.out.print(cur.label);
            if(cur.next != null){
                System.out.print("  -next->  ");
            }else{
                System.out.println();
                break;
            }
            cur = cur.next;
        }
        cur = head;
        while(cur.next != null) {

            System.out.println(cur.label + "  -random-> " + cur.random.label);
            cur = cur.next;
        }
    }

    public static void main(String[] args) {
        RandomListNode a = new RandomListNode(1);
        RandomListNode b = new RandomListNode(2);
        RandomListNode c = new RandomListNode(3);
        RandomListNode d = new RandomListNode(4);
        RandomListNode e = new RandomListNode(5);
        RandomListNode f = new RandomListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        a.random = f;
        b.random = a;
        c.random = c;
        d.random = f;
        e.random = c;
        f.random = b;

        printRandomList(a);

        System.out.println("=============================");
        RandomListNode rr = copyRandomList(a);

        printRandomList(rr);


    }
}
