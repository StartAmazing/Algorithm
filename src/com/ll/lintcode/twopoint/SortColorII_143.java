package com.ll.lintcode.twopoint;

/**
 * 给定一个有n个对象（包括k种不同的颜色，并按照1到k进行编号）的数组，将对象进行分类使相同颜色的对象相邻，并按照1,2，...k的顺序进行排序。
 *
 * 样例
 * 样例1
 *
 * 输入:
 * [3,2,2,1,4]
 * 4
 * 输出:
 * [1,2,2,3,4]
 * 样例2
 *
 * 输入:
 * [2,1,1,2,2]
 * 2
 * 输出:
 * [1,1,2,2,2]
 * 挑战
 * 一个相当直接的解决方案是使用计数排序扫描2遍的算法。这样你会花费O(k)的额外空间。你否能在不使用额外空间的情况下完成？
 *
 * 注意事项
 * 不能使用代码库中的排序函数来解决这个问题
 * k <= n
 */
public class SortColorII_143 {

    //version 1: O(nlog k), the best algorithm based on comparing
    public void sortColorII(int[] nums, int k){
        if (nums == null || nums.length < 2){
            return;
        }
        rainbowSort(nums, 0, nums.length - 1, 1, k);
    }

    private void rainbowSort(int[] nums,
                             int left,
                             int right,
                             int colorFrom,
                             int colorTo){
        if(colorFrom == colorTo){
            return;
        }
        if (left >= right){
            return;
        }
        int mid = colorFrom + (colorTo - colorFrom) / 2;
        int l = left;
        int r = right;
        while (l <= r){
            while (l <= r && nums[l] <= mid){
                l ++;
            }
            while (l <= r && nums[r] > mid){
                r --;
            }
            if (l <= r){
                swap(nums, l ++, r --);
            }
        }

        rainbowSort(nums, left, r, colorFrom, mid);
        rainbowSort(nums, l, right, mid + 1, colorTo);
    }

    private void swap(int[] nums, int x, int y){
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }








}
