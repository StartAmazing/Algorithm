package com.ll.lintcode.basic.twopoint;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 分割一个整数数组，使得奇数在前偶数在后。
 *
 * 样例
 * 样例1:
 *
 * 输入: [1,2,3,4]
 * 输出: [1,3,2,4]
 * 样例2:
 *
 * 输入: [1,4,2,3,5,6]
 * 输出: [1,3,5,4,2,6]
 * 挑战
 * 在原数组中完成，不使用额外空间。
 *
 * 注意事项
 * 答案不唯一。你只需要给出一个合法的答案。
 */
public class PartitionArrayByOddAndEven_373 {

    public void partitionArray(int[] nums) {
        if (nums == null || nums.length < 2){
            return;
        }

        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            while(left < right && nums[left] % 2 == 1){
                left ++;
            }
            while(left < right && nums[right] % 2 == 0){
                right --;
            }
            if(left < right){
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left ++;
                right --;
            }
        }
    }

    public static int tableSizeFor(int c) {
        int n = c - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= (1 << 30)) ? (1 << 30) : n + 1;
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new ConcurrentHashMap<>(8);
        map.put(1, 1000);

        int initialCapacity = 5;
        System.out.println(tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
        initialCapacity = 7;
        System.out.println(tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
        initialCapacity = 11;
        System.out.println(tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
        initialCapacity = 16;
        System.out.println(tableSizeFor(initialCapacity + (initialCapacity >>> 1) + 1));
    }

}
