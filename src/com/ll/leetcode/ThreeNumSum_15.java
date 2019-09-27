package com.ll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和，leetcode_15
 */
public class ThreeNumSum_15 {

    private static List<List<Integer>> getThreeNum(Integer[] arr){
        if(arr.length < 3){
            List<List<Integer>> x = new ArrayList<List<Integer>>();
            return x;
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int len = arr.length;
        for(int i = 1; i <= arr.length - 2; i++){
            for(int j = 0,k = len -1 ;;){
                if(arr[i] + arr[j] + arr[k] == 0){
                    ArrayList<Integer> a = new ArrayList<>();
                    a.add(arr[i]);
                    a.add(arr[j]);
                    a.add(arr[k]);
                    res.add(a);
                }
                if(arr[j] + arr[k] + arr[i] < 0){
                    j ++;
                }else{
                    k --;
                }
                if( j >= i || k <= i){
                    break;
                }
            }
        }
        return res;
    }

    private static List<List<Integer>> threeSum2(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < len - 2 && nums[i] <= 0; i++) {
            if (nums[i] + nums[i + 1] + nums[i + 2] > 0) {
                break;
            }
            if (nums[i] + nums[len - 2] + nums[len - 1] < 0) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = len - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{0,0,0};
        List<List<Integer>> threeNum = getThreeNum(arr);
        System.out.println(threeNum.size());
        threeNum.forEach(item -> {
            item.forEach(i ->{
                System.out.print(i + "    ");
            });
            System.out.println();
        });

        System.out.println("=========");
        int[] arr1 = new int[]{0,0,0};
        List<List<Integer>> lists = threeSum2(arr1);
        System.out.println(lists.size());
        lists.forEach(item -> {
            item.forEach(i ->{
                System.out.print(i + "    ");
            });
            System.out.println();
        });

    }
}
