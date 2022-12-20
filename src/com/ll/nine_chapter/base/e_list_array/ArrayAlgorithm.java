package com.ll.nine_chapter.base.e_list_array;

import java.util.*;

public class ArrayAlgorithm {
    /**
     * @link https://www.lintcode.com/problem/6/
     * @param a: sorted integer array A
     * @param b: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] a, int[] b) {
        if(a == null || a.length == 0) {
            return b;
        }

        if(b == null || b.length == 0) {
            return a;
        }

        int[] res = new int[a.length + b.length];
        int aIdx = 0, bIdx = 0, resIdx = 0;
        while(aIdx < a.length && bIdx < b.length) {
            if(a[aIdx] < b[bIdx]) {
                res[resIdx++] = a[aIdx++];
            } else {
                res[resIdx++] = b[bIdx++];
            }
        }

        while(aIdx < a.length) {
            res[resIdx++] = a[aIdx++];
        }

        while(bIdx < b.length) {
            res[resIdx++] = b[bIdx++];
        }

        return res;
    }


    /**
     * @link https://www.lintcode.com/problem/547/description
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     *          we will sort your return value in output
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
            return new int[]{};
        }

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        Set<Integer> resSet = new HashSet<>();
        int idx1 = 0;
        int idx2 = 0;
        while(idx1 < nums1.length && idx2 < nums2.length) {
            if(nums1[idx1] == nums2[idx2]) {
                resSet.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else if(nums1[idx1] < nums2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        idx1 = 0;
        int[] res = new int[resSet.size()];
        for(Integer ele : resSet) {
            res[idx1++] = ele;
        }

        return res;
    }


    /**
     * @link https://www.lintcode.com/problem/911
     * @param nums: an array
     * @param k: a target value
     * @return: the maximum length of a subarray that sums to k
     */
    public static int maxSubArrayLen(int[] nums, int k) {
        if(nums == null || nums.length < 1) {
            return 0;
        }

        int maxLen = 0, sum = 0;
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumMap.putIfAbsent(sum, i);
            if(sumMap.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - sumMap.get(sum - k));
            }
        }

        return maxLen;
    }

    /**
     * @link https://www.lintcode.com/problem/41/
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum = Math.max(sum, nums[i]);
            maxSum = Math.max(maxSum, sum);
        }


        return maxSum;
    }

    /**
     * @link https://www.lintcode.com/problem/138/
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length < 2) {
            res.add(0);
            res.add(0);
            return res;
        }

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.get(sum) != null) {
                res.add(map.get(sum) + 1);  // 从之后的第一个数开始算起
                res.add(i);
                return res;
            }

            map.put(sum, i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] data = new int[]{-2,-1,2,1};
        int target = 1;
        int len = maxSubArrayLen(data, target);
        System.out.println(len);
    }
}
