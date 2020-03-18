package com.ll.lintcode.dp;

import java.util.*;

/**
 * 给一个由 无重复的正整数 组成的集合，找出满足任意两个元素 (Si, Sj) 都有 Si % Sj = 0 或 Sj % Si = 0 成立的最大子集
 * <p>
 * 样例
 * 例1:
 * <p>
 * 输入: nums =  [1,2,3],
 * 输出: [1,2] or [1,3]
 * 例2:
 * <p>
 * 输入: nums = [1,2,4,8],
 * 输出: [1,2,4,8]
 * 注意事项
 * 如果有多种解集，返回其中任意一个。
 */
public class LargestDivisibleSubSet_603 {

    public List<Integer> largestDivisibleSubset(int[] nums) {

        Set<Integer> res = new HashSet<>();
        if (nums == null || nums.length < 2) {
            return null;
        }

        Arrays.sort(nums);

        List<Set<Integer>> f = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> tmp = new HashSet<>();
            tmp.add(nums[i]);
            f.add(tmp);
        }

        for (int i = 1; i < nums.length; i++) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f.get(i).size() <= f.get(j).size()) {
                    maxIndex = f.get(maxIndex).size() > f.get(j).size() ? maxIndex : j;
                }
            }
            f.get(i).addAll(f.get(maxIndex));
        }
        for (int i = 0 ; i < nums.length; i++){
            if (res.size() < f.get(i).size()){
                res = f.get(i);
            }
        }

        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        LargestDivisibleSubSet_603 dto = new LargestDivisibleSubSet_603();
        int[] data = new int[]{3,6,9,27,81,22,24,56,243,486,726,18,36,72};
        dto.largestDivisibleSubset(data);
    }
}
