package com.ll.leetcode;

import com.ll.utils.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyTest {
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, Character[]> charMap = new HashMap<>();
        charMap.put('2',new Character[]{'a','b','c'});
        charMap.put('3',new Character[]{'d','e','f'});
        charMap.put('4',new Character[]{'g','h','i'});
        charMap.put('5',new Character[]{'j','k','l'});
        charMap.put('6',new Character[]{'m','n','o'});
        charMap.put('7',new Character[]{'p','q','r','s'});
        charMap.put('8',new Character[]{'t','u','v'});
        charMap.put('9',new Character[]{'w','x','y','z'});
        ArrayList<String> arrStr = new ArrayList<>();
        char[] chars = digits.toCharArray();
        process(arrStr,chars,0,"", charMap);
        return arrStr;
    }
    private static void process(ArrayList<String> arrStr, char[] chars,int start, String origin, HashMap<Character, Character[]> charMap){
        if(origin.length() == chars.length ){
            arrStr.add(origin);
            return;
        }

        for(char c : charMap.get(chars[start])){
            process(arrStr,chars,start + 1,origin + c,charMap);
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 1){
            return lists[0];
        }
        return sort(lists,0,lists.length - 1);
    }
    private static ListNode sort(ListNode[] lists, int left, int right){
        if(left == right){
            return lists[left];
        }
        int mid = left + ((right - left) >> 1);
        ListNode leftNode = sort(lists, left, mid);
        ListNode rightNode = sort(lists, mid + 1, right);
        return merage(leftNode, rightNode);
    }
    private static ListNode merage(ListNode node1, ListNode node2){
        ListNode help = new ListNode(0);
        ListNode cur = help;
        ListNode index1 = node1;
        ListNode index2 = node2;
        while(index1 != null && index2 != null){
            if(index1.val < index2.val){
                cur.next = index1;
                index1 = index1.next;
            }else{
                cur.next = index2;
                index2 = index2.next;
            }
            cur = cur.next;
        }
        while(index1 != null){
            cur.next = index1;
            index1 = index1.next;
            cur = cur.next;
        }
        while(index2 != null){
            cur.next = index2;
            index2 = index2.next;
            cur = cur.next;
        }
        return help.next;
    }

    public static void main(String[] args) {
//        List<String> strings = letterCombinations("23");
//        strings.forEach(item -> {
//            System.out.print(item + "\t");
//        });

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(5);

        ListNode listNode2 = new ListNode(1);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(4);

        ListNode listNode3 = new ListNode(2);
        listNode3.next = new ListNode(6);
        ListNode[] listNodes = new ListNode[]{listNode1,listNode2,listNode3,null};

        ListNode listNode = mergeKLists(listNodes);
        ListNode head = listNode;
        while (head != null){
            System.out.println(head.val + "\t");
            head = head.next;
        }

    }
}
