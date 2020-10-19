package com.ll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 * 输入: nums = [1,2,3]
 * 输出:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subsets
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSet_78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length < 1) {
            return ans;
        }
        Arrays.sort(nums);
        help(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void help(int[] nums, int startIdx, ArrayList<Integer> subList, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subList));
        for(int i = startIdx; i < nums.length; i++) {
            subList.add(nums[i]);
            help(nums, i + 1, subList, ans);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSet_78 dto = new SubSet_78();
        int[] data = new int[]{1, 2, 3};
        List<List<Integer>> subsets = dto.subsets(data);
        System.out.println(subsets);
    }

}
