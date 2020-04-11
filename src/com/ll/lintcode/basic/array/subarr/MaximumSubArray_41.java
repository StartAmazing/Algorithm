package com.ll.lintcode.basic.array.subarr;

/**
 * 给定一个整数数组，找到一个具有最大和的子数组，返回其最大和
 * 子数组最少包含一个数
 */
public class MaximumSubArray_41 {

    //version 1: Greedy
    public int maxSubArray1(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            max = Math.max(max,sum);
            //这里跟0比较是因为最小子数组是[],他的元素之和为0
            sum = Math.max(sum,0);
        }

        return max;
    }

    //version 2: prefix sum
    public int maxSubArray2(int[] nums){
        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;
        for(int i = 0; i < nums.length; i ++){
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < prefixSum.length; i ++){
            for(int j = i + 1; j < prefixSum.length ;j ++){
                if(res < prefixSum[j] - prefixSum[i]){
                    res = prefixSum[j] - prefixSum[i];
                }
            }
        }

        return res;
    }
    //version 2: prefix sum
    public int maxSubArray3(int[] nums){
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i ++){
            sum += nums[i];
            max = Math.max(max , sum - minSum);
            minSum = Math.min(minSum, sum);
        }

        return max;
    }

    //version 3: dp
    public int maxSubArray4(int[] nums){
        if (nums == null || nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] global = new int[2];
        int[] local = new int[2];
        global[0] = nums[0];
        local[0] = nums[0];
        for (int i = 1; i < n; i ++){
            local[i % 2] = Math.max(nums[i],local[(i - 1) % 2] + nums[i]);
            global[i % 2] = Math.max(local[i % 2],global[(i - 1) % 2]);
        }
        return global[(n - 1) % 2];
    }

    public static void main(String[] args) {
        MaximumSubArray_41 dto = new MaximumSubArray_41();
        int i = dto.maxSubArray1(new int[]{-2, 2, -3, 4, -1, 2, 1, -5, 3});
        System.out.println(i);
    }

}
