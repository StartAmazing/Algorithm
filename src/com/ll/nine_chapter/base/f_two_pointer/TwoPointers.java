package com.ll.nine_chapter.base.f_two_pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoPointers {

    /**
     * @link https://www.lintcode.com/problem/539/
     * @param nums: an integer array
     * @return: nothing
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int left = 0;
        while (left < nums.length && nums[left] != 0) {
            left++;
        }
        for (int right = left + 1; right < nums.length; right++) {
            if(nums[right] == 0) {
                continue;
            }
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
            while (left < nums.length && nums[left] != 0) {
                left++;
            }
        }
    }

    /**
     * @link https://leetcode.cn/problems/remove-duplicates-from-sorted-array/
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }

        if (nums.length < 2) {
            return nums.length;
        }

        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != nums[left]) {
                left++;
                int tmp = nums[right];
                nums[right] = nums[left];
                nums[left] = tmp;
            }
            right++;
        }

        return left + 1;
    }

    /**
     * @link https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length < 2) {
            return new int[]{};
        }

        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[]{left+1, right+1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }

        }

        return new int[]{};
    }

    /**
     * @link https://leetcode.cn/problems/3sum/
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        return threeSum(nums, 0);
    }

    private static List<List<Integer>> threeSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int subTarget = target - nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == subTarget) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (sum < subTarget) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    /**
     * @link https://leetcode.cn/problems/valid-triangle-number/
     * @param nums
     * @return
     */
    public static int triangleNumber(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0;
        // a <= b <= c
        for (int i = 2; i < nums.length; i++) {
            int left = 0, right = i - 1;
            while (left < right) {
                int sum = nums[right] + nums[left];
                if (sum > nums[i]) {
                    res += right - left;
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;
    }



    public static void main(String[] args) {
        int[] data = new int[]{2, 2, 3, 4};
        int cnt = triangleNumber(data);
        System.out.println(cnt);
    }

}
