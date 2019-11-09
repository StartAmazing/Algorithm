package com.ll.zs.advance.mytest;

import java.util.HashMap;

/**
 * 给出一个数组，数组中可以有正数，负数，和0，给出一个目标值
 * 求累加和为这个是目标值的长子数组长度
 *
 * 扩展，一个数组中，既有奇数也有偶数，求其中奇数和偶数相等的
 * 所有子数组中长度最长的长度（思路，把其中的奇数变为1，偶数变
 * 为-1，求其中最长累加和为0的最长子数组长度即可）
 *
 * 扩展：给出一个数组，将数组进行任意拆分成子数组，求这些数组
 * 中的数字进行异或后为0的所有子数组个数最多情况下的子数组个数
 * ，返回子数组的个数
 * 异或的性质
 *      1、异或运算满足交换律和结合律
 *      2、异或运算中0和任何数进行异或运算都还是那个数，N和自己异或为0
 */
public class MaxSubArrAccToTarget {

    public static int maxLength(int[] arr, int aim){
        if(arr == null || arr.length == 0){
            return  0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(map.containsKey(sum -aim)){
                len = Math.max(i - map.get(sum - aim), len);    //从之前的位置后一个位置到当前位置之和即为aim
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return len;
    }

    //扩展2：
    public static int mostEOR(int[] arr){
        int ans = 0;
        int xor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0 , -1);
        for(int i = 0; i < arr.length; i++){
            xor ^= arr[i];
            if(map.containsKey(xor)){
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if(i > 0){      //最晚的时候一定要更新dp
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor,i);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) throws InterruptedException {
        for (;;){
            for (int i = 0; i < 2.6 * 1000000000 * 2 / 5; i ++){
                ;
                Thread.sleep(10);
            }
        }
    }


}
