package com.ll.lintcode.basic.hash_heap;

import java.util.*;

/**
 * 将 k 个有序数组合并为一个大的有序数组。
 *
 * 样例
 * 样例 1:
 *
 * 输入:
 *   [
 *     [1, 3, 5, 7],
 *     [2, 4, 6],
 *     [0, 8, 9, 10, 11]
 *   ]
 * 输出: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
 * 样例 2:
 *
 * 输入:
 *   [
 *     [1,2,3],
 *     [1,2]
 *   ]
 * 输出: [1,1,2,2,3]
 * 挑战
 * 在 O(N log k) 的时间复杂度内完成：
 *
 * N 是所有数组包含的整数总数量。
 * k 是数组的个数。
 */
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val){
        this.val = val;
        this.next = null;
    }
}


public class MergeKSortedLists_104 {

    //version 1. use a priority queue
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    };

    public ListNode mergeKLists(List<ListNode> lists){
        if (lists == null || lists.size() < 1){
            return null;
        }
        Queue<ListNode> heap = new PriorityQueue<>(lists.size(), ListNodeComparator);
        for (int i = 0; i < lists.size(); i++){
            if (lists.get(i) != null){
                heap.add(lists.get(i));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()){
            ListNode head = heap.poll();
            tail.next = head;
            if(head.next != null){
                heap.add(head.next);
            }
        }

        return dummy.next;
    }


    //version 2. merge two list
    public ListNode mergeKlists2(List<ListNode> lists){

        while (lists.size() > 1){
            List<ListNode> tmp = new ArrayList<>();
            for (int i = 0; i < lists.size(); i += 2){
                if (i + 1 == lists.size()){
                    tmp.add(lists.get(i));
                    break;
                }else{
                    ListNode node1 = lists.get(i);
                    ListNode node2 = lists.get(i + 1);
                    ListNode merged = merge(node1, node2);
                    tmp.add(merged);
                }
            }
            lists.clear();
            lists.addAll(tmp);
        }
        return lists.get(0);
    }
    private ListNode merge(ListNode node1, ListNode node2){
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode head1 = node1;
        ListNode head2 = node2;
        while (head1 != null && head2 != null){
            if (head1.val < head2.val){
                tail.next = head1;
                head1 = head1.next;
            }else{
                tail.next = head2;
                head2 = head2.next;
            }
            tail = tail.next;
        }
        if (head1 != null){
            tail.next = head1;
        }
        if(head2 != null){
            tail.next = head2;
        }
        return dummy.next;
    }

    //version 3: divide conquer
    public ListNode mergeKLists3(List<ListNode> lists){
        if (lists == null || lists.size() < 1){
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }

    private ListNode mergeHelper(List<ListNode> lists,
                                 int startIdx,
                                 int endIdx){
        if (startIdx == endIdx){
            return lists.get(startIdx);
        }

        int mid = startIdx + (endIdx - startIdx) / 2;
        ListNode left = mergeHelper(lists, startIdx, mid);
        ListNode right = mergeHelper(lists, mid + 1, endIdx);
        return merge(left,right);
    }




}
