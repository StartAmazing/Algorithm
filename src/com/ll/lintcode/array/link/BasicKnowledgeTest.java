package com.ll.lintcode.array.link;

import com.ll.lintcode.utils.ListNode;

public class BasicKnowledgeTest {

    public void print(ListNode node){
        while (node != null){
            System.out.print(node.val);
            System.out.print(" -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        //connect nodes and connect them to a linked list
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;

        //print head
        ListNode head = node1;

        BasicKnowledgeTest dto = new BasicKnowledgeTest();
        dto.print(head);    //1 -> 2 -> 3 -> null

        //print head again
        node1 = node2;
        dto.print(head);    //1 -> 2 -> 3 -> null

        head = node1;
        dto.print(head);    // 2 -> 3 -> null
    }


}
