package com.ll.leetcode;

public class SingleNonDuplicate_540 {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length % 2 == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return nums[0];
        }

        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        SingleNonDuplicate_540 dto = new SingleNonDuplicate_540();
        int[] data = new int[]{3,3,7,7,10,11,11};
//        int[] data = new int[]{1,1,2,3,3,4,4,8,8};
        System.out.println(dto.singleNonDuplicate(data));
    }
}
