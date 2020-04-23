package com.ll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 *
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 *
 * 请返回这个数组中「优美子数组」的数目。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * 示例 2：
 *
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * 示例 3：
 *
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PerfectSubarray_1248 {

    /**
     * Use math method
     * @param nums 给出数组
     * @param k 奇数个数
     * @return 子数组满足条件总数
     */
    public int numberOfSubarraysWithMathMethod(int[] nums, int k) {
        List<Integer> oddlist = new ArrayList<>();
        oddlist.add(-1);
        for(int i = 0; i < nums.length; i ++){
            if(nums[i] % 2 == 1){
                oddlist.add(i);
            }
        }
        oddlist.add(nums.length);
        int ans = 0;
        for(int i = 1; i < oddlist.size() - k; i ++){
            ans += (oddlist.get(i) - oddlist.get(i - 1)) * (oddlist.get(i + k) - oddlist.get(i + k - 1));
        }

        return ans;
    }

    /**
     * Use prefix
     * @param nums 给出数组
     * @param k 奇数个数
     * @return 子数组满足条件总数
     */
    public int numberOfSubarraysWithMathPrefix(int[] nums, int k) {
        return 0;
    }
}
