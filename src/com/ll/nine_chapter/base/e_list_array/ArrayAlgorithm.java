package com.ll.nine_chapter.base.e_list_array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayAlgorithm {

    /**
     * @param a: An integer array
     * @param b: An integer array
     * @return: a double whose format is *.5 or *.0
     */
    public double findMedianSortedArrays(int[] a, int[] b) {
        int m = a.length;
        int n = b.length;
        if (((m + n) & 1) == 1) {
            return findKth(a, 0, b, 0, (m + n) / 2 + 1);
        }
        return (findKth(a, 0, b, 0, (m + n) / 2)  + findKth(a, 0, b, 0, (m + n) / 2 + 1)) / 2.0;
    }

    private double findKth(int[] a, int aStart,
                           int[] b, int bStart, int kth) {
        if (aStart >= a.length) {
            return b[bStart + kth - 1];
        }
        if (bStart >= b.length) {
            return a[aStart + kth - 1];
        }

        if (kth == 1) {
            return Math.min(a[aStart], b[bStart]);
        }
        if (kth == 2) {
            return Math.max(a[aStart], b[bStart]);
        }

        int aValue = aStart + kth / 2 - 1 < a.length ? a[aStart + kth / 2 - 1] : Integer.MAX_VALUE;
        int bValue = bStart + kth / 2 - 1 < b.length ? b[bStart + kth / 2 - 1] : Integer.MAX_VALUE;
        if (aValue > bValue) {
            return findKth(a, aStart, b, bStart + kth / 2,kth - kth / 2);
        } else {
            return findKth(a, aStart + kth / 2, b, bStart, kth - kth / 2);
        }

    }

    /**
     * @link https://www.lintcode.com/problem/41/
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(sum, max);
            sum = Math.max(0, sum);
        }

        return max;
    }

    public int maxSumArray_solution2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }

        int preSum = 0;
        int max = Integer.MIN_VALUE;
        int preSumMin = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            max = Math.max(max, preSum - preSumMin);
            preSumMin = Math.min(preSumMin, preSum);
        }

        return max;
    }

    /**
     * @link https://www.lintcode.com/problem/138/
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum)) {
                res.add(map.get(sum) + 1);
                res.add(i);
                return res;
            }
            if (nums[i] == 0) {
                res.add(i);
                res.add(i);
                return res;
            }
            map.put(sum, i + 1);
        }

        return res;
    }


    public static void main(String[] args) {

    }
}
