package com.ll.leetcode.exercise.linkedlist_part_1;


//已知链表头指针与数值x，
// 将所有小于x的结点放在大于或者等于x的结点之前，且保持这些结点庲的想对位置
//leetcode86   medium
public class LinkedListPartition {

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

    public static ListNode partition(ListNode head, int target){
        ListNode less_head = new ListNode(Integer.MAX_VALUE);
        ListNode more_head = new ListNode(Integer.MAX_VALUE);   //设置两个临时头结点
        ListNode less_ptr = less_head;
        ListNode more_ptr = more_head;      //对应指针指向这两个头结点
        while(head != null){
            if(head.val < target){      //如果节点值小于target，则将该节点插入less_ptr后面
                less_ptr.next = head;   //连接完成后，less_ptr向后移动，指向head
                less_ptr = less_ptr.next;
            }else{          //否则将该节点插入more_ptr后
                more_ptr.next = head;
                more_ptr = more_ptr.next;
            }
            head = head.next;       //遍历链表
        }
        less_ptr.next = more_head.next;     //将less链表尾，与more链表头相连接
        more_ptr.next = null;       //将more_ptr即链表尾节点next置空
        return less_head.next;      //less_head的next节点即为新链表头结点，返回
    }

    public static void printLinkedList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            if(head.next != null){
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
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
        ListNode i = new ListNode(9);
        ListNode j = new ListNode(10);

        a.next = b;
        b.next = e;
        e.next = c;
        c.next = j;
        j.next = i;
        i.next = f;
        f.next = g;
        g.next = d;
        d.next = h;

        printLinkedList(a);
        a = partition(a,5);
        printLinkedList(a);


    }


}
