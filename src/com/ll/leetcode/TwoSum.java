package com.ll.leetcode;

import java.util.HashMap;

/**
 * description:给定一个数组和一个目标值，找出数组中和为目标值的两个数
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复使用
 * 比如：
 *      给定nums=[2,4,7,11,23] 目标值为9 所以返回[0,3]
 */

public class TwoSum {
    //map的第一个值用来存放数组元素，第二个值用来存储该元素的索引
    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] solution(int[] m, int target){
        for(int i = 0; i< m.length; i++){
            int x = target - m[i];
            if(map.containsKey(x)){
               return new int[]{map.get(x),i};
            }else{
                map.put(m[i],i);
            }

        }
        return null;
    }

}
