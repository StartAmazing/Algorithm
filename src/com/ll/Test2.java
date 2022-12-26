package com.ll;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.util.Stack;

public class Test2 {

    /**
     *
     * @param nums source data
     * @return int[]
     *         int[0]--the max value,
     *         int[1]--the number of max value
     */
    public static int[] getMaxValueAndCnt(int[] nums) {
        int[] res = new int[2];
        if (nums == null || nums.length < 1) {
            return res;
        }

        int left = 0, right = nums.length - 1;
        while(left + 1 < right) {
            int mid = left + (right - left) / 2;
            int l = mid, r = mid;
            while (l > left && nums[l] == nums[l - 1]) {
                l--;
            }

            while (r < right && nums[r] == nums[r + 1]) {
                r++;
            }

            if (l == left && r == right) {
                return new int[]{nums[mid], r - l + 1};
            }

            if (l == left || r == right) {
                if (l == left) {
                    if (nums[l] < nums[r + 1]) {
                        left = r;
                    } else {
                        right = l;
                    }
                } else { // r == right
                    if (nums[r] < nums[l - 1]) {
                        right = l;
                    } else {
                        left = r;
                    }
                }

            } else {
                if (nums[r] > nums[r + 1]) {
                    right = r;
                }

                if (nums[l] > nums[l - 1]) {
                    left = l;
                }
            }

        }

        if (nums[left] == nums[right]) {
            return new int[]{nums[left], right - left + 1};
        } else {
            int maxValue = nums[left] < nums[right] ? nums[right] : nums[left];
            return new int[]{maxValue, 1};
        }
    }



    public static void main(String[] args) {

        int[] data = new int[]{1, 3, 3, 3, 4, 5, 5, 5, 5, 5, 6, 7, 8, 8, 8, 8, 8};
        int[] res = getMaxValueAndCnt(data);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }

}
