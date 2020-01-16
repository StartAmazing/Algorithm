package com.ll.lintCode.array;

import java.util.*;

/**
 * 给出两个数组，写出一个方法求出他们的交集
 */
public class IntersectionOfTwoArrays_547 {

    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int a : nums2) {
            set.add(a);
        }
        List<Integer> list = new ArrayList<>();
        for (int b : nums1) {
            if (set.contains(b) && !list.contains(b)) {
                list.add(b);
            }
        }

        int[] res = new int[list.size()];
        int idx = 0;
        for (int ele : list) {
            res[idx++] = ele;
        }

        return res;
    }


    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return an integer array
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int idx1 = 0;
        int idx2 = 0;
        Set<Integer> set = new HashSet<>();
        while (idx1 < nums1.length && idx2 < nums2.length) {
            if (nums1[idx1] == nums2[idx2]) {
                set.add(nums1[idx1]);
                idx1++;
                idx2++;
            } else {
                if (nums1[idx1] > nums2[idx2]) {
                    idx2++;
                } else {
                    idx1++;
                }
            }
        }

        int[] res = new int[set.size()];
        int idx = 0;
        for (int ele : set) {
            res[idx++] = ele;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 1};
        int[] nums2 = new int[]{2, 2};
        IntersectionOfTwoArrays_547 dto = new IntersectionOfTwoArrays_547();
        int[] ints = dto.intersection2(nums1, nums2);
        System.out.println(ints[0]);
    }


}
