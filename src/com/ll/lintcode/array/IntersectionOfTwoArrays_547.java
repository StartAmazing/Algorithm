package com.ll.lintcode.array;

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

    //version3
    public int[] intersection3(int[] nums1, int[] nums2) {
        if(nums1.length ==0 || nums2.length ==0){
            return new int[0];
        }


        Arrays.sort(nums1);

        Set<Integer> setList = new HashSet<>();
        for(int i = 0 ;i < nums2.length; i++){
            if(isInArr(nums1, nums2[i])){
                setList.add(nums2[i]);
            }
        }

        int[] res = new int[setList.size()];
        int idx = 0;
        for (int ele : setList) {
            res[idx++] = ele;
        }

        return res;
    }

    private boolean isInArr(int[] nums, int i){
        int l = 0;
        int r = nums.length - 1;

        while(l + 1 < r){
            int mid = l + (r -l) / 2;
            if(nums[l] == i || nums[r] == i || nums[mid] == i ){
                return true;
            }else if(nums[mid] > i){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        if(nums[l] == i || nums[r] == i){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums2 = new int[]{5,0,0,6,1,6,2,2,4};
        int[] nums1 = new int[]{4,7,9,7,6,7};
        IntersectionOfTwoArrays_547 dto = new IntersectionOfTwoArrays_547();
        int[] ints = dto.intersection3(nums1, nums2);
        for (int i = 0; i < ints.length; i ++){
            System.out.print(ints[i] + " ");
        }
    }


}
