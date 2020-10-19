package com.ll.leetcode;

import com.ll.muke.queue.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * <p>
 * 说明：解集不能包含重复的子集。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,2,2]
 * 输出:
 * [
 * [2],
 * [1],
 * [1,2,2],
 * [2,2],
 * [1,2],
 * []
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSetII_90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return ans;
        }

        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void helper(int[] nums, int startIdx, ArrayList<Integer> subList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subList));
        for (int i = startIdx; i < nums.length; i++) {
            if (i > startIdx && nums[i] == nums[i - 1]){
                continue;
            }
            subList.add(nums[i]);
            helper(nums, i + 1, subList, ans);
            subList.remove(subList.size() - 1);
        }
    }
}
