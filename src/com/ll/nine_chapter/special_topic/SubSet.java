package com.ll.nine_chapter.special_topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能具有重复数字的列表，返回其所有可能的子集
 * 子集中不能包含重复元素
 */
public class SubSet {

    public static List<List<Integer>> subSetWithoutOup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }

        // 1. sort
        Arrays.sort(nums);

        // 2. dfs
        List<Integer> subList = new ArrayList<>();
        subSetsWithoutOupHelper(nums, 0, subList, res);

        return res;
    }

    private static void subSetsWithoutOupHelper(int[] nums,
                                                int startIdx,
                                                List<Integer> subList,
                                                List<List<Integer>> res) {

        res.add(new ArrayList<>(subList));
        for (int i = startIdx; i < nums.length; i++) {
            subList.add(nums[i]);
            subSetsWithoutOupHelper(nums, i + 1, subList, res);
            subList.remove(subList.size() - 1);
        }
    }

    public static List<List<Integer>> subSetWithOup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return res;
        }

        // 1. sort
        Arrays.sort(nums);

        // 2. dfs
        List<Integer> subList = new ArrayList<>();
        subSetsWithOupHelper(nums, 0, subList, res);

        return res;
    }

    private static void subSetsWithOupHelper(int[] nums,
                                                int startIdx,
                                                List<Integer> subList,
                                                List<List<Integer>> res) {

        res.add(new ArrayList<>(subList));
        for (int i = startIdx; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && i > startIdx) {
                continue;
            }
            subList.add(nums[i]);
            subSetsWithOupHelper(nums, i + 1, subList, res);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 2, 3, 3};
        System.out.println(subSetWithOup(nums));
    }
}
