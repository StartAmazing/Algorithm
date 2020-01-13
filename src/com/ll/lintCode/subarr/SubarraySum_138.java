package com.ll.lintCode.subarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 给定一个整数数组，找到和为零的子数组。你的代码应该返回满足要求的子数组（其中一个）的起始位置和结束位置
 * 至少有一个子数组的和为0
 */
public class SubarraySum_138 {
    public List<Integer> subarraySum(int[] nums){
        List<Integer> res = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return res;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,0);
        int sum = 0;
        for(int i = 0 ; i < nums.length; i ++){
            sum += nums[i];
            if(map.containsKey(sum)){
                res.add(map.get(sum));
                res.add(i);
                return res;
            }
            if(nums[i] == 0){
                res.add(i);
                res.add(i);
                return res;
            }
            map.put(sum, i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        SubarraySum_138 dto = new SubarraySum_138();
        List<Integer> integers = dto.subarraySum(new int[]{-3, 1, 2, -3, 4});
        System.out.println("args = " + integers);
    }
}