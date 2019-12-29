package com.ll.zs.basic.mytest;

public class FirstTarget {
    public static int binarySearch(int[] nums, int target) {

        int start = 0;
        int end = nums.length -1;
        while(start + 1 < end){
            int mid = start + (end - start) / 2;
            if(nums[mid] == target){
                end = mid;
            }else if(nums[mid] < target){
                start = mid;
            }else{
                end = mid;
            }
        }
        if(nums[start] == target){
            return start;
        }
        if(nums[end] == target){
            return end;
        }

        return -1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,3,4,5,6,8,13,17,18};
        int i = binarySearch(nums, 17);
        System.out.println(i);
    }
}
