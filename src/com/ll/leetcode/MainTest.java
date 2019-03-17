package com.ll.leetcode;

public class MainTest {

    public static void main(String[] args){
//        TwoSum twoSum = new TwoSum();
//        int[] nums = {2,4,7,11,24};
//        int target = 9;
//        int []m =twoSum.solution(nums, target);
//        for(int x : m){
//            System.out.print(x + "  ");
//        }
//        AddTwoNum addTwoNum = new AddTwoNum();
//        ListNode a = new ListNode(3);
//        a.next = new ListNode(4);
//        a.next.next = new ListNode(7);
//        ListNode b = new ListNode(5);
//        b.next = new ListNode(4);
//        b.next.next = new ListNode(7);
//        ListNode x = addTwoNum.solution(a,b);
//        while( x != null ){
//            if(x.next == null){
//                System.out.println(x.val);
//            }else {
//                System.out.print(x.val + " -> ");
//            }
//            x = x.next;
//        }
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        String s = "abcabcbb";
        int l = lengthOfLongestSubstring.solution(s);
        System.out.println(l);
    }

}
