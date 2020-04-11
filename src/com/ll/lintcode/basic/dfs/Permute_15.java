package com.ll.lintcode.basic.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给定一个数字列表，返回其所有可能的排列。
 *
 * 样例
 * 样例 1：
 *
 * 输入：[1]
 * 输出：
 * [
 *   [1]
 * ]
 * 样例 2：
 *
 * 输入：[1,2,3]
 * 输出：
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 * 挑战
 * 使用递归和非递归分别解决。
 *
 * 注意事项
 * 你可以假设没有重复数字。
 */
public class Permute_15 {

    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (null == nums || nums.length < 1){
            return res;
        }

        List<Integer> subList = new ArrayList<>();
        help(nums, new boolean[nums.length], subList, res);
        return res;
    }

    private void help(int[] nums,
                      boolean[] visited,
                      List<Integer> permutation,
                      List<List<Integer>> res){
        if (nums.length == permutation.size()){
            res.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (visited[i]) {
                continue;
            }

            permutation.add(nums[i]);
            visited[i] = true;
            help(nums, visited, permutation, res);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permute_15 dto = new Permute_15();
        int[] data = new int[]{1,2,3};
        List<List<Integer>> permute = dto.permute(data);
        System.out.println(permute);
    }
}
