package com.ll.lintcode.basic.binarysearch;

/**
 * 假设一个旋转排序的数组其起始位置是未知的（比如0 1 2 4 5 6 7 可能变成是4 5 6 7 0 1 2）。
 *
 * 你需要找到其中最小的元素。
 *
 * 样例
 * 样例 1:
 *
 * 输入 :[2,1]
 * 输出 : 1.
 * 样例 2:
 *
 * 输入 :[4,4,5,6,7,0,1,2]
 * 输出: 0.
 * 注意事项
 * The array may contain duplicates.
 */
public class findMinimumInRotatedSortedArrayII_160 {
    public int findMin(int[] num) {
        //  这道题目在面试中不会让写完整的程序
        //  只需要知道最坏情况下 [1,1,1....,1] 里有一个0
        //  这种情况使得时间复杂度必须是 O(n)
        //  因此写一个for循环就好了。
        //  如果你觉得，不是每个情况都是最坏情况，你想用二分法解决不是最坏情况的情况，那你就写一个二分吧。
        //  反正面试考的不是你在这个题上会不会用二分法。这个题的考点是你想不想得到最坏情况。
        int min = num[0];
        for (int i = 1; i < num.length; i++) {
            if (num[i] < min)
                min = num[i];
        }
        return min;
    }

}
